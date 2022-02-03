package mybatis;

import lombok.Data;

@Data
public class BoardDTO {
	private String num;
	private String title;
	private String content;
	private String id;
//	private java.sql.Date postdate;	// React에서는 타임스탬프 값으로 나옴
	private String postdate;
	private String visitcount;
}
