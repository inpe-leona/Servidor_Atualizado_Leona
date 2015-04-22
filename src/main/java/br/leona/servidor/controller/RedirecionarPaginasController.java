package br.leona.servidor.controller;

public class RedirecionarPaginasController {
    
    public static final String webinf = "WEB-INF/jsp/";
    
    //region Index
    public static final String CONTATO = webinf+"index/contato.jsp";    
    public static final String LOGIN = webinf+"index/login.jsp";
    public static final String LOGIN2 = webinf+"index/login2.jsp";
    public static final String LEMBRARSENHA = webinf+"index/lembrarsenha.jsp";
    //endregion
    
    //region Usuario
    public static final String CADASTRO_USUARIO = webinf+"usuario/cadastro.jsp";
    public static final String CADASTRO_USUARIO_SUCESSO = webinf+"usuario/cadastrosucesso.jsp";
    public static final String MENU = webinf+"usuario/menu.jsp";
    public static final String MENU_ADM = webinf+"usuario/menuadm.jsp";
    public static final String LISTAGEM_USUARIO = webinf+"usuario/lista.jsp";    
    //endregion
    
    //region Estação
    public static final String LISTAGEM_ESTACAO = webinf+"estacao/lista.jsp";
    public static final String CADASTRO_ESTACAO = webinf+"estacao/cadastro.jsp";
    public static final String LISTAGEM_SERVICOS = webinf+"estacao/servicos.jsp";
    //endregion
    
    //region Observação
    public static final String LISTAGEM_OBSERVACAO = webinf+"observacao/lista.jsp";
    public static final String CADASTRO_OBSERVACAO = webinf+"observacao/cadastro.jsp";
    public static final String VISUALIZAR_OBSERVACAO = webinf+"observacao/visualizar.jsp";
    //endregion    
    
    //region Imagem
    static String GESTAO_IMAGEM = webinf+"imagem/imagem.jsp";
    static String PASTAIMAGEM = webinf+"imagem/pastaImagem.jsp";
    static String IMAGENSOBS = webinf+"imagem/imagensObservacao.jsp";
    //endregion
    
    
    static String GESTAO_OBSERVACAO = webinf+"observacao/observacao.jsp";
    static String CADASTRO_OBSERVACAO_OK = webinf+"observacao/okobservacao.jsp";
    static String GESTAO_USUARIO = webinf+"usuario/usuario.jsp";
    static String GESTAO_ESTACAO = webinf+"estacao/estacao.jsp";
    static String CADASTRO_ESTACAO_SUCESSO = webinf+"estacao/estacaosucesso.jsp";
    
}
