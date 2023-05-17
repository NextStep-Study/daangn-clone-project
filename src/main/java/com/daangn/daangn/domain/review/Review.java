package com.daangn.daangn.domain.review;

import com.daangn.daangn.domain.Member.Member;
import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {

	@Id
	@GeneratedValue
	@Column(name = "review_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member writer;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "member_id")
//	private Member target;

	private String content;

	private int point;

	@CreationTimestamp
	private LocalDateTime created_at;
}
