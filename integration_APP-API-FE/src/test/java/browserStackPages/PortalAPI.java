package browserStackPages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

public class PortalAPI {

    @Test
    public void testGetRequest() {
        Response response = RestAssured.get("https://app.test.sharedaffairs.com/api/auth/user-signup-verification/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MzI3LCJlbWFpbCI6ImZta2xvYWR0ZXN0OUB5b3BtYWlsLmNvbSIsImlhdCI6MTY4ODQ1NDQ3MywiZXhwIjoxNjg5MDU5MjczfQ.tC4oTaJ7uSrNN_gm7MOUYmyBrOx8lMxYtPLfnQVRJqc");

        int statusCode = response.getStatusCode();
        String res = response.getBody().asString();


        System.out.println(res);
        System.out.println("Status code: " + statusCode);
        System.out.println("Response body: " + response.getBody().asString());

        if (res.contains("200")){

            System.out.println("Request is failed");
        }
    }

    @Test
    public void testPostRequest() {
        String requestBody = "{\"email\": \"fmkloadtest9@yopmail.com\",\"password\": \"FMKTesting@123\", \"browserId\": \"Ut in ex\", \"otp\": \"12133\"}";

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("https://app.test.sharedaffairs.com/api/auth/sign_in");

        int statusCode = response.getStatusCode();
        System.out.println("Status code: " + statusCode);
        System.out.println("Response body: " + response.getBody().asString());
        String resp = response.getBody().asString();
        System.out.println("Response body: " + resp);

        //String res = "{\"statusCode\":200,\"message\":\"User Sign in Successful\",\"response\":{\"jwtToken\":\"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MzI3LCJlbWFpbCI6ImZta2xvYWR0ZXN0OUB5b3BtYWlsLmNvbSIsImlhdCI6MTY4ODQ1NjQwMSwiZXhwIjoxNjg5MDYxMjAxfQ.8na6PkqLAIIYqvwECavWv75au1fPiIAysJRpTspZUkk\",\"user\":{\"id\":327,\"userTypeId\":3,\"stripeCustomerId\":\"cus_O0SW0Kn4AatrKz\",\"stripeSubscriptionId\":\"sub_1NH66WKfBzxo7LobghXcM6hA\",\"email\":\"fmkloadtest9@yopmail.com\",\"password\":\"$2b$10$Lo0CgJAUy1MT6PAGejU.KugTvIIt1Qji7ClmEuPnzo7guCYS838Qu\",\"userRegistrationDate\":\"2023-06-02T06:37:12.000Z\",\"lastLoggedIn\":\"2023-07-04T07:35:46.441Z\",\"isActive\":true,\"isEmailVerified\":true,\"rememberOtpForSevenDays\":false,\"createdDate\":\"2023-06-02T06:37:12.022Z\",\"updatedDate\":\"2023-07-04T07:35:46.000Z\",\"isWillPaid\":false,\"isSubscriptionActive\":true,\"holidayExpiryDate\":\"2023-07-01T00:00:00.000Z\",\"isInfiniteHoliday\":false,\"previousUsertype\":3,\"userProfile\":{\"id\":327,\"businessName\":\"\",\"firstName\":\"TestingKite6\",\"lastName\":\"Load Testing\",\"secondaryEmail\":null,\"imageName\":\"my_image\",\"notificationsPermission\":{\"daily-report\":[\"email\"],\"remind-email\":[\"email\"],\"reset-password\":[\"email\"],\"forgot-password\":[\"email\"],\"send-otp-to-user\":[\"email\"],\"stripe-will-payment\":[\"email\"],\"user-client-upgrade\":[\"email\"],\"secondary-email-added\":[\"email\"],\"stripe-premium-payment\":[\"email\"],\"user-exit-holiday-mode\":[\"email\"],\"change-password-of-user\":[\"email\"],\"secondary-email-deleted\":[\"email\"],\"user-contact-us-to-user\":[\"email\"],\"user-enter-holiday-mode\":[\"email\"],\"stripe-subscribe-premium\":[\"email\"],\"user-contact-us-to-admin\":[\"email\"],\"user-signup-verification\":[\"email\"],\"vault-opened-owner-email\":[\"email\"],\"vault-assigned-to-trustee\":[\"email\"],\"invite-contact-system-user\":[\"email\"],\"stripe-unsubscribe-premium\":[\"email\"],\"vault-opened-trustee-email\":[\"email\"],\"vaults-assigned-to-trustee\":[\"email\"],\"business-user-sign-up-email\":[\"email\"],\"stop-premium-payment-for-user\":[\"email\"],\"vault-opened-co-trustee-email\":[\"email\"],\"invite-contact-non-system-user\":[\"email\"],\"new-business-registration-email\":[\"email\"],\"shared-folder-assigned-to-contacts\":[\"email\"],\"vault-owner-blocks-an-opened-vault\":[\"email\"],\"invite-contact-system-business-user\":[\"email\"],\"vault-reminder-email-to-vault-owner\":[\"email\"],\"vault-opened-request-made-by-trustee\":[\"email\"],\"account-owner-deletes-account-to-owner\":[\"email\"],\"vault-owner-request-blocked-by-trustee\":[\"email\"],\"invite-contact-non-system-business-user\":[\"email\"],\"account-owner-deletes-account-to-contacts\":[\"email\"],\"vault-owner-request-blocked-by-co-trustee\":[\"email\"],\"vault-owner-deletes-opened-vault-to-trustee\":[\"email\"],\"vault-owner-deletes-opened-vault-to-co-trustee\":[\"email\"],\"vault-opened-request-made-by-trustee-to-trustee\":[\"email\"],\"vault-opened-request-made-by-trustee-to-co-trustee\":[\"email\"]},\"createdDate\":\"2023-06-02T06:37:12.022Z\",\"updatedDate\":\"2023-06-19T08:26:14.674Z\",\"secondaryEmailConfig\":{\"emailAlert\":true,\"receiveOtp\":false,\"recoverAccount\":false},\"phoneNumber\":\"\",\"isPhoneNumberConfirmed\":null,\"smsConfig\":null},\"userType\":{\"id\":3,\"userTypeName\":\"Free\",\"digitalVaultCount\":1,\"personalVaultCount\":0,\"sharedVaultCount\":0,\"willVaultCount\":1,\"funeralVaultCount\":1,\"probateVaultCount\":1,\"passwordVaultCount\":1,\"totalVaultCount\":4,\"willVaultConfig\":null,\"funeralVaultConfig\":null,\"sharedVaultConfig\":null,\"probateVaultConfig\":null,\"passwordVaultConfig\":null,\"vaultStorageLimit\":1,\"cost\":0}}}}";

        JSONObject jsonResponse = new JSONObject(resp);
        String jwtToken = jsonResponse.getJSONObject("response").getString("jwtToken");

        System.out.println("JWT Token: " + jwtToken);


 Response rep = RestAssured.get("https://app.test.sharedaffairs.com/api/auth/user-signup-verification/"+jwtToken);

            int statusCodeUserSignVer = response.getStatusCode();
            String res = response.getBody().asString();


            System.out.println(res);
            System.out.println("Status code: " + statusCode);
            System.out.println("Response body: " + response.getBody().asString());

            if (res.contains("200")) {

                System.out.println("This is the verification response"+res);
            }

        }

    }

