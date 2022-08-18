package com.sparta.domain.controller;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.sparta.domain.Memo;
import com.sparta.domain.MemoPasswordDto;
import com.sparta.domain.MemoRepository;
import com.sparta.domain.MemoRequestDto;
import com.sparta.domain.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/post")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }
    @GetMapping("/api/post")
    public List<Memo> readMemo(){
       return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/post/{id}")
    public Long deleteMemo(@PathVariable Long id){
        memoRepository.deleteById(id);
        return id;
    }
    @PutMapping("/api/post/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        memoService.update(id,requestDto);
        return id;
    }

}
