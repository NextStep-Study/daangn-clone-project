package com.daangn.daangn.review.service;

import com.daangn.daangn.review.dto.ReviewDto;
import com.daangn.daangn.review.entity.Review;
import com.daangn.daangn.review.mapper.ReviewMapper;
import com.daangn.daangn.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    public List<Review> findAll(Long productId) {
         return reviewRepository.findAllByProduct_Id(productId);
    }

    public Long createNewReview(Review review) {
         return reviewRepository.save(review).getId();
    }

    public Review findById(Long reviewId) {
        return reviewRepository.findById(reviewId).get();
    }

    public Review updateById(ReviewDto.Patch patchRequest, Long reviewId) {
        Review targetReview = findById(reviewId);
        reviewMapper.patchRequestToEntity(patchRequest, targetReview);

        reviewRepository.save(targetReview);

        return targetReview;
    }

    public void deleteById(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

}
