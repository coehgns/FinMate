package com.example.finmate.domain.visitor.domain.repository

import com.example.finmate.domain.visitor.domain.Visitor
import org.springframework.data.jpa.repository.JpaRepository

interface VisitorRepository : JpaRepository<Visitor, Long> {
    fun findTopByOrderByIdAsc(): Visitor?
}