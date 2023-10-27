package tn.iit.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode.Include;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class StudentDto {
	@Include
	private int id;
	private String name;
	private Character gender;
/*public static void main(String[] args) {
	StudentDto st1=new StudentDto(1,"Kamel",'M');
	
}
	*/

}
