
  Feature: F12_CreateOrder | Create successful order

    Scenario: user can create successful order
      Given user open browser to create order
      And user navigate to website to create order
      And user login to create order

      When user navigates to product to create order
      And user click on Adidas shoes to create order
      And user choose size to create order
      And user click on add to cart to create order
      And user click shopping cart button
      And user check the checkbox
      And user click on CHECKOUT
      And user fill billing address form
      And user choose Ground
      And user choose money order
      And user click continue
      And user click confirm

      Then user should see your order has been successfully processed