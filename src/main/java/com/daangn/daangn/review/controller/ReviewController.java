package com.daangn.daangn.review.controller;

import com.daangn.daangn.review.dto.ReviewDto;
import com.daangn.daangn.review.entity.Review;
import com.daangn.daangn.review.mapper.ReviewMapper;
import com.daangn.daangn.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;

    @GetMapping("/products/{product-id}/reviews")
    public ResponseEntity<List<ReviewDto.Get>> findAllByProductId(@PathVariable("product-id") Long productId) {
        List<Review> reviewList = reviewService.findAll(productId);
        List<ReviewDto.Get> getRequests = reviewMapper.entityToGetRequest(reviewList);

        return ResponseEntity.ok(getRequests);
    }

    @PostMapping("/reviews")
    public ResponseEntity<?> createNewReview(@PathVariable("product-id") Long productId, @RequestBody ReviewDto.Post postRequest) {
        Review review = reviewMapper.postRequestToEntity(postRequest);
        Long savedId = reviewService.createNewReview(review);

        URI location = createLocation(savedId);
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/reviews/{review-id}")
    public ResponseEntity<ReviewDto.Get> findById(@PathVariable("review-id") Long reviewId) {
        Review review = reviewService.findById(reviewId);
        ReviewDto.Get getRequest = reviewMapper.entityToGetRequest(review);

        return ResponseEntity.ok(getRequest);
    }

    @PatchMapping("/reviews/{review-id}")
    public ResponseEntity<ReviewDto.Get> updateById(@PathVariable("review-id") Long reviewId, @RequestBody ReviewDto.Patch patchRequest) {
        Review review = reviewService.updateById(patchRequest, reviewId);
        ReviewDto.Get getRequest = reviewMapper.entityToGetRequest(review);

        return ResponseEntity.ok(getRequest);
    }

    @DeleteMapping("/reviews/{review-id}")
    public ResponseEntity<?> deleteById(@PathVariable("review-id") Long reviewId) {
        reviewService.deleteById(reviewId);

        return ResponseEntity.noContent().build();
    }


    private static URI createLocation(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
