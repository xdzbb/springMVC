var bdShare = bdShare || {
	version : "1.0"
};
bdShare.ready = bdShare.ready || function(B, C) {
	C = C || document;
	if (/complete/.test(C.readyState)) {
		B()
	} else {
		if (C.addEventListener) {
			if ("interactive" == C.readyState) {
				B()
			} else {
				C.addEventListener("DOMContentLoaded", B, false)
			}
		} else {
			var A = function() {
				A = new Function;
				B()
			};
			void function() {
				try {
					C.body.doScroll("left")
				} catch (D) {
					return setTimeout(arguments.callee, 10)
				}
				A()
			}();
			C.attachEvent("onreadystatechange", function() {
				("complete" == C.readyState) && A()
			})
		}
	}
};
bdShare.loadScript = bdShare.loadScript || function(B) {
	var A = document.createElement("script");
	A.src = B;
	bdShare.ready(function() {
		document.getElementsByTagName("script")[0].parentNode.appendChild(A)
	})
};
if (bdShare.fn && bdShare.fn.init) {
	bdShare.fn.init()
} else {
	bdShare.velocity = {
		start : +new Date
	};
	if (!bdShare.ApiPVLogger) {
		bdShare
				.loadScript("resource/js/logger.js?cdnversion="
						+ Math.ceil(new Date() / 3600000))
	}
	document.getElementById("bdshare_js").src = "resource/js/bds_s_v2.js?cdnversion="
			+ Math.ceil(new Date() / 3600000)
}
if (+[ 1, ]) {
	var shell = document.getElementById("bdshell_js");
	shell && shell.parentNode.removeChild(shell)
};