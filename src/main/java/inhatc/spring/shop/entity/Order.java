package inhatc.spring.shop.entity;

import inhatc.spring.shop.constant.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime orderDate;    // 주문 날짜

    @Enumerated(EnumType.STRING)
    private OrderStatus status;     // 주문 상태

    @Builder.Default
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)  // mappedBy(연관 관계의 주인 표시)
    private List<OrderItem> orderItems = new ArrayList<>();     // 주문 상품

}
