package com.example.simple_board.reply.service;

import com.example.simple_board.reply.db.ReplyEntity;
import com.example.simple_board.reply.db.ReplyRepository;
import com.example.simple_board.reply.model.ReplyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;

    public ReplyEntity create(
            ReplyRequest replyRequest
    ){
        var entity = ReplyEntity.builder()
                .postId(replyRequest.getPostId())
                .userName(replyRequest.getUserName())
                .password(replyRequest.getPassword())
                .status("REGISTERED")
                .title(replyRequest.getTitle())
                .content(replyRequest.getContent())
                .repliedAt(LocalDateTime.now())
                .build();

        return replyRepository.save(entity);
    }
}
