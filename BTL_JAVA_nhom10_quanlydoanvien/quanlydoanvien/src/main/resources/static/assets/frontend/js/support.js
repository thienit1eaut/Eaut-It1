var SOTHER = (function () {
  var toastrConfig = function () {
    if ($.isEmptyObject(toastr.options) == true) {
      toastr.options = {
        closeButton: false,
        debug: false,
        newestOnTop: false,
        progressBar: false,
        positionClass: "toast-bottom-left",
        preventDuplicates: true,
        onclick: null,
        showDuration: "300",
        hideDuration: "1000",
        timeOut: "5000",
        extendedTimeOut: "1000",
        showEasing: "swing",
        hideEasing: "linear",
        showMethod: "fadeIn",
        hideMethod: "fadeOut",
      };
    }
    if (typeNotify != 'undefined' && typeNotify != undefined && typeNotify != '' && messageNotify != 'undefined' && messageNotify != undefined && messageNotify != '') {
      toastr[typeNotify](messageNotify);
    }
  }
  var showToastr = function () {
    $(document).on('click', '.show_toastr', function (event) {
      event.preventDefault();
      var typeNotify = $(this).attr('data-typeNotify');
      var messageNotify = $(this).attr('data-messageNotify');
      toastr.clear();
      toastr[typeNotify](messageNotify);
    });
  }
  var notify = function (typeNotify, messageNotify) {
    toastr.clear();
    toastr[typeNotify](messageNotify);
  }
  return {
    _: function () {
      toastrConfig();
      showToastr();
    },
    notify: function (typeNotify, messageNotify) {
      return notify(typeNotify, messageNotify);
    }
  };
})();
window.addEventListener("DOMContentLoaded", (event) => {
  SOTHER._();
});

var ALERT = {
  message: function (json) {
    toastr.clear();
    if (json.code == 200) {
      toastr["success"](json.message);
    } else {
      toastr["error"](json.message);
    }
  },
  reload: function (json) {
    toastr.clear();
    if (json.code == 200) {
      toastr["success"](json.message);
	  setTimeout(function () {
	    window.location.reload();
	  }, 3000);
    } else {
      toastr["error"](json.message);
    }
  },
  redirectLogin: function (json) {
    toastr.clear();
    if (json.code == 200) {
      toastr["success"](json.message);
      window.location.href = "login";
    } else {
      toastr["error"](json.message);
    }
  },
  redirect: function (json) {
    toastr.clear();
    if (json.code == 200) {
      toastr["success"](json.message);
	  setTimeout(function () {
  	    window.location.href = (json.redirect);
  	  }, 3000);
    } else {
      toastr["error"](json.message);
    }
  },
  redirectPaynow: function (json) {
    toastr.clear();
    if (json.code == 200) {
      toastr["success"](json.message);
      window.location.href = "thanh-toan";
    } else {
      toastr["error"](json.message);
    }
  },
};