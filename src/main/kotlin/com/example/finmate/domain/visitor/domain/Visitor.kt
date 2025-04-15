package com.example.finmate.domain.visitor.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "tbl_visitor")
class Visitor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "visitor_count")
    var visitorCount: Long = 0
) {
    fun increment(): Long {
        return this.visitorCount++
    }
}