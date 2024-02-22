package com.alth.backend.comment.service;

import com.alth.backend.comment.dto.CommentUpdateRequest;
import com.alth.backend.comment.repository.CommentRepository;
import com.alth.backend.comment.domain.Comment;
import com.alth.backend.comment.dto.CommentCreateRequest;
import com.alth.backend.comment.dto.CommentResponse;
import com.alth.backend.comment.dto.ReCommentResponse;
import com.alth.backend.member.domain.Member;
import com.alth.backend.member.service.MemberService;
import com.alth.backend.post.domain.Post;
import com.alth.backend.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final PostRepository postRepository;
    private final MemberService memberService;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentResponse create(Long id, CommentCreateRequest request) {

        Comment comment = request.toEntity(request);
        Member member = memberService.getMember();
        Post post = postRepository.findById(id).orElseThrow(RuntimeException::new);

        comment.confirmWriter(member);
        comment.confirmMember(member);
        comment.confirmPost(post);

        commentRepository.save(comment);

        return new CommentResponse().toResponse(comment);
    }

    @Transactional
    public ReCommentResponse createReComment(Long postId, Long commentId, CommentCreateRequest request) {
        Comment comment = request.toEntity(request);
        Member member = memberService.getMember();
        Post post = postRepository.findById(postId).orElseThrow(RuntimeException::new);

        comment.confirmMember(member);
        comment.confirmWriter(member);
        comment.confirmPost(post);
        comment.confirmParent(commentRepository.findById(commentId).orElseThrow(RuntimeException::new));

        commentRepository.save(comment);
        return new ReCommentResponse().toResponse(comment);
    }

    public List<CommentResponse> getComments(Long id) {
        Post post = postRepository.findById(id).orElseThrow(RuntimeException::new);
        return commentRepository.findByPostId(id);
    }

    @Transactional
    public CommentResponse update(Long id, CommentUpdateRequest request) {
        Member member = memberService.getMember();
        Comment comment = commentRepository.findById(id).orElseThrow(RuntimeException::new);

        if (member.getNickname() != comment.getWriter()) {
            throw new RuntimeException("not match member");
        }
        comment.update(request.getContent());
        return new CommentResponse().toResponse(comment);
    }

    @Transactional
    public String delete(Long id) {
        Member member = memberService.getMember();
        Comment comment = commentRepository.findCommentByIdWithParent(id)
                .orElseThrow(() -> new RuntimeException("not found comment id"));

        if (member.getNickname() != comment.getWriter()) {
            throw new RuntimeException("not match member");
        }

        if (comment.getChildren().size() != 0) {
            comment.delete();
        } else {
            commentRepository.delete(getDeletedAncestorComment(comment));
        }
        return "삭제되었습니다.";
    }

    private Comment getDeletedAncestorComment(Comment comment) {
        Comment parent = comment.getParent();
        if (parent != null && parent.getChildren().size() == 1 && parent.getIsDeleted()) {
            return getDeletedAncestorComment(parent);
        }
        return comment;
    }
}
