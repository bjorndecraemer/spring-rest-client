package bjorn.petprojects.springrestclientexamples.api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by bjorn on 02 Dec, 2018
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserData {

    List<User> data;
}
