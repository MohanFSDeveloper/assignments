
csp.service("cspService", function($scope) {

	this.InvokeGet = function () {
		$http.get("processStmnt").then(function (response) {
			return  response.data;
		});

	}

});
