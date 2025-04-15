package com.example.finmate.domain.visitor.sevice

import com.example.finmate.domain.visitor.domain.Visitor
import com.example.finmate.domain.visitor.domain.repository.VisitorRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AddVisitorService(
    private val visitorRepository: VisitorRepository
) {
    @Transactional
    fun execute() {
        val visitor = visitorRepository.findTopByOrderByIdAsc()
            ?: visitorRepository.save(Visitor())

        visitor.increment()
        visitorRepository.save(visitor)
    }
}