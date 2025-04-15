package com.example.finmate.domain.visitor.presentation

import com.example.finmate.domain.visitor.sevice.AddVisitorService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/visitors")
class VisitorController(
    private val addVisitorService: AddVisitorService
) {
    @PostMapping
    fun addVisitorCount() {
        addVisitorService.execute()
    }
}