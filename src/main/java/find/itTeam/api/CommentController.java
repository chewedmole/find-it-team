package find.itTeam.api;

import find.itTeam.dto.ChangeComment;
import find.itTeam.dto.CreateComment;
import find.itTeam.entity.CommentEntity;
import find.itTeam.service.CommentService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // todo к какому посту?
    @PostMapping("create-comment")
    public CommentEntity createComment(@RequestBody CreateComment requestComment) {
        return commentService.createNewComment(requestComment);
    }

    // todo
    @GetMapping("edit-comment/{id}/{text}/{dateTime}")
    public CommentEntity updateComment(@PathVariable Long id, @RequestBody CommentEntity changeComment) {
        return commentService.updateComment(id, changeComment);
    }

    @GetMapping("delete-comment/{id}")
    public String deleteComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }
}

