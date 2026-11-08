package ra.baitap12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ra.baitap12.model.dto.request.CreateReviewDTO;
import ra.baitap12.model.dto.response.ApiResponse;
import ra.baitap12.model.dto.response.ReviewResponse;
import ra.baitap12.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/reviews")
    @PreAuthorize("hasRole('USER')")
    public ApiResponse<ReviewResponse> createReview(
            @RequestBody CreateReviewDTO dto
    ) {
        return reviewService.createReview(dto);
    }

    @GetMapping("/products/{id}/reviews")
    @PreAuthorize("isAuthenticated()")
    public ApiResponse<List<ReviewResponse>> getProductReviews(
            @PathVariable Long id
    ) {
        return reviewService.getProductReviews(id);
    }
}