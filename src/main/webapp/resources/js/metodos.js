var email = 'http://emailocadora.azurewebsites.net/api/enviaremail';

function ObjetoEmail($scope){
    $scope.EMAIL = {
        Nome: '',
        Email: '',
        Mensagem: ''
    }
}

function MandarEmail($scope, $http){
    $scope.EnvioEmailServer = function(){
        if ($scope.EMAIL.Email==""){
            alert("Email é Obrigatório!");
        }else{
            lblValidacao.style.visibility='hidden';
            lblErro.style.visibility='hidden';
            lblok.style.visibility='hidden';
            lblMensagem.style.visibility='visible';
            $http.post(email+'server', $scope.EMAIL)
                .success(function(data,status){
                    if (data) {
                        lblMensagem.style.visibility = 'hidden';
                        lblok.style.visibility = 'visible';
                    }else{
                        lblMensagem.style.visibility = 'hidden';
                        lblValidacao.style.visibility = 'visible';
                    }
                })
                .error(function(data){
                    lblMensagem.style.visibility='hidden';
                    lblErro.style.visibility='visible';
                })
        }
    }
}


