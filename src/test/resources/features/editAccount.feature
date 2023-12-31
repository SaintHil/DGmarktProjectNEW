@D2DGMRT-8
Feature: My account edit Functionality

  Background: The user is on home page
    Given The user is logged in with valid credentials "nesibe@ogux.sss" and "test1234"
    And The user clicks on my account in the my account subcategory
    And The user clicks on the Edit Account button
  @D2DGMRT-45
  Scenario Outline: The user should be able to update the My Account on the DgMarkt website.
    When The user clicks on "<FirstName>" box,"<LastName>" box,"<Email>" box,"<Telephone>" box select enters valid data
    And The user click continue button
    Then Verify that you can receive a my account verification message "<message>"
    And The use standardizes login data
    Examples:
      | FirstName                        | LastName                         | Email           | Telephone                        | message                                              |
      | nesibe                           | oguz                             | nesibe@ogux.sss | 1234567890                       | Success: Your account has been successfully updated. |
      | 123456                           | ..?A!                            | nesibe@ogux.sss | 1234567890                       | Success: Your account has been successfully updated. |
      | n                                | oguz                             | nesibe@ogux.sss | 1234567890                       | Success: Your account has been successfully updated. |
      | nesibenesibenesibenesibenesibene | oguz                             | nesibe@ogux.sss | 1234567890                       | Success: Your account has been successfully updated. |
      | nesibe                           | o                                | nesibe@ogux.sss | 1234567890                       | Success: Your account has been successfully updated. |
      | nesibe                           | oguzoguzoguzoguzoguzoguzoguzoguz | nesibe@ogux.sss | 1234567890                       | Success: Your account has been successfully updated. |
      | nesibe                           | oguz                             | nesibe@ogux.sss | 123                              | Success: Your account has been successfully updated. |
      | nesibe                           | oguz                             | nesibe@ogux.sss | 12345678901234567890123456789012 | Success: Your account has been successfully updated. |
  @D2DGMRT-66
  Scenario Outline: The user should not be able to update the My Account section on the DgMarkt site with incorrect information.
    When The user clicks on the Edit Account button
    And The user clicks on "<FirstName>" box,"<LastName>" box,"<Email>" box,"<Telephone>" box select enters invalid data
    And The user click continue button
    Then Verify that you can receive my account alert message "<message>"
    Examples:
      | FirstName                            | LastName                             | Email           | Telephone                         | message                                         |
      |                                      | oguz                                 | nesibe@ogux.sss | 123                               | First Name must be between 1 and 32 characters! |
      | nesibenesibenesibenesibenesibenesibe | oguz                                 | nesibe@ogux.sss | 123                               | First Name must be between 1 and 32 characters! |
      | nesibe                               |                                      | nesibe@ogux.sss | 123                               | Last Name must be between 1 and 32 characters!  |
      | nesibe                               | oguzoguzoguzoguzoguzoguzoguzoguzoguz | nesibe@ogux.sss | 123                               | Last Name must be between 1 and 32 characters!  |
      | nesibe                               | oguz                                 | nesibe@ogux.sss |                                   | Telephone must be between 3 and 32 characters!  |
      | nesibe                               | oguz                                 | nesibe@ogux.sss | 1                                 | Telephone must be between 3 and 32 characters!  |
      | nesibe                               | oguz                                 | nesibe@ogux.sss | 12                                | Telephone must be between 3 and 32 characters!  |
      | nesibe                               | oguz                                 | nesibe@ogux.sss | 123456789012345678901234567890123 | Telephone must be between 3 and 32 characters!  |
  @D2DGMRT-67
  Scenario Outline:The user should not be able to update the account section on the DGMART site with incorrect email information.
    When The user clicks on the Edit Account button
    And The user clicks on "<FirstName>" box,"<LastName>" box,"<Email>" box,"<Telephone>" box select enters invalid data
    And The user click continue button
    Then The warning message contains '<message>'
    Examples:
      | FirstName | LastName | Email         | Telephone | message                                                  |
      | nesibe    | oguz     | n.oguz        | 123       | Lütfen e-posta adresine bir "@" işareti ekleyin.         |
      | nesibe    | oguz     | n.oguz@       | 123       | Lütfen "@" işaretinden sonra gelen kısmı ekleyin.        |
      | nesibe    | oguz     | n.oguz@gmail  | 123       | E-Mail Address does not appear to be valid!              |
      | nesibe    | oguz     | n.oguz@gmail. | 123       | ".", "gmail." adı içinde yanlış bir konumda kullanılmış. |
