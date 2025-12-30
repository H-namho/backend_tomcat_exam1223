package com.smhrd.web.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) // 1씩 자동증가
	private Long b_idx;
	
	private String b_title;
	@Column(length=2000)
	private String b_content;
	@Column(updatable = false)
	private String b_writer;
	
	@Column(length=200)
	private String b_file_path; // 파일 경로를 저장하는 컬럼추가
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(insertable = false, updatable=false, columnDefinition = "datatime default now()")
	private LocalDateTime b_datetime;
	@Column(insertable = false, updatable =false, columnDefinition = "int default 0")
	private Long b_count;
}
