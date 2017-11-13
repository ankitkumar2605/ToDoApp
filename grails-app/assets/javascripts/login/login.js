//= require jquery-2.2.0.min
//= require jquery.validate


$(document).ready(function () {
    $("#addUser").validate({
        debug: true,
        rules: {
            firstName: {
                required: true,
                minlength: 4
            },
            lastName: {
                required: true,
                minlength: 4
            },
            password: {
                required: true,
                minlength: 5
            },
            confirmPassword: {
                required: true,
                minlength: 5,
                equalTo: "#addUser #password"
            },
        },
        submitHandler: function (form) {
            var isValidForm = $("#addUser").valid();
            if (isValidForm) {
                var data = {
                    firstName: $("#firstName").val(),
                    lastName: $("#lastName").val(),
                    userEmail: $("#userEmail").val(),
                    password: $("#password").val(),
                    isAdmin: false,
                    isActivated: false
                };
                $.ajax({
                    url: form.action,
                    type: "POST",
                    data: data,
                    success: function (result) {
                        if (!result.success && result.isParamsIncorrect) {
                            alert("Please send correct params")
                        } else if (!result.success && result.isUserExists) {
                            alert("User already Exists")

                        } else if (result.success && !result.isUserExists) {
                            window.location = "sendActivationCode"
                        } else {
                            alert("Please try again")

                        }
                    },
                    error: function (result) {
                        alert("Some error occurred!!Please try again")
                    }
                });
            }
        }
    })
    $("#loginForm").validate({
          debug: true,
          rules: {
              loginUserEmail:{
                  required:true,
                  email:true
              },
              loginPassword :{
                  required :true,
                  minlength :5
              }
          },
        submitHandler: function (form) {
            var isValidForm = $("#loginForm").valid();
            if (isValidForm) {
                var data = {
                    loginUserEmail: $("#loginUserEmail").val(),
                    loginPassword: $("#loginPassword").val()
                     };
                $.ajax({
                    url: form.action,
                    type: "POST",
                    data: data,
                    success: function (result) {
                       if(result.success && result.isActive){
                           window.location = "/task/index"
                       }else if(result.success && !result.isActive){
                           window.location = "sendActivationCode"
                       }else{
                           alert("Email or Password is incorrect!!")
                       }
                    },
                    error: function (result) {
                        alert("Some error occurred!!Please try again")
                    }
                });
            }
        }
    })
    $("#activationForm").validate({
          debug: true,
          rules: {
              activationCode:{
                  required:true,
              }
          },
        submitHandler: function (form) {
            var isValidForm = $("#activationForm").valid();
            if (isValidForm) {
                var data = {
                    activationCode: $("#activationCode").val(),
                     };
                $.ajax({
                    url: form.action,
                    type: "POST",
                    data: data,
                    success: function (result) {
                        if(result.success){
                            window.location = "/task/loadTasks"
                        }else{
                            alert("Enter correct activation code")
                        }
                    },
                    error: function (result) {
                        alert("Some error occurred!!Please try again")
                    }
                });
            }
        }
    })
})
