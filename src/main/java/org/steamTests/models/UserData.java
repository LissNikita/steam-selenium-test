package org.steamTests.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserData {

    String successfulLogin;
    String successfulPassword;

    String unsuccessfulLogin;
    String unsuccessfulPassword;
}
