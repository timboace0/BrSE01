package ra.baitap12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import ra.baitap12.model.dto.request.CreateReviewDTO;
import ra.baitap12.model.dto.response.ApiResponse;
import ra.baitap12.model.dto.response.ReviewResponse;
import ra.baitap12.model.entity.Product;
import ra.baitap12.model.entity.Review;
import ra.baitap12.model.entity.User;
import ra.baitap12.repository.OrderItemRepository;
import ra.baitap12.repository.ProductRepository;
import ra.baitap12.repository.ReviewRepository;
import ra.baitap12.repository.UserRepository;
import ra.baitap12.security.principal.UserPrincipal;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    private User getCurrentUser() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        UserPrincipal userPrincipal =
                (UserPrincipal) authentication.getPrincipal();

        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User not found"
                ));
    }

    @Transactional
    public ApiResponse<ReviewResponse> createReview(CreateReviewDTO dto) {

        User user = getCurrentUser();

        if (dto.getProductId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Product ID cannot be empty"
            );
        }

        if (dto.getRating() == null || dto.getRating() < 1 || dto.getRating() > 5) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Rating must be between 1 and 5"
            );
        }

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Product not found"
                ));

        boolean hasPurchased = orderItemRepository
                .existsByOrder_User_IdAndProduct_Id(user.getId(), product.getId());

        if (!hasPurchased) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "You can only review products you have purchased"
            );
        }

        Review review = Review.builder()
                .user(user)
                .product(product)
                .rating(dto.getRating())
                .comment(dto.getComment())
                .createdDate(LocalDateTime.now())
                .build();

        Review savedReview = reviewRepository.save(review);

        return ApiResponse.<ReviewResponse>builder()
                .status(201)
                .message("Review created successfully")
                .data(convertToDTO(savedReview))
                .build();
    }

    public ApiResponse<List<ReviewResponse>> getProductReviews(Long productId) {

        productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Product not found"
                ));

        List<ReviewResponse> reviews = reviewRepository
                .findByProduct_IdOrderByCreatedDateDesc(productId)
                .stream()
                .map(this::convertToDTO)
                .toList();

        return ApiResponse.<List<ReviewResponse>>builder()
                .status(200)
                .message("Get product reviews successfully")
                .data(reviews)
                .build();
    }

    private ReviewResponse convertToDTO(Review review) {
        return ReviewResponse.builder()
                .id(review.getId())
                .userId(review.getUser().getId())
                .email(review.getUser().getEmail())
                .productId(review.getProduct().getId())
                .productName(review.getProduct().getName())
                .rating(review.getRating())
                .comment(review.getComment())
                .createdDate(review.getCreatedDate())
                .build();
    }
}