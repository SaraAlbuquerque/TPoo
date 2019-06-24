/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho02.modelo;

import trabalho02.dados.Database;

/**
 *
 * @author Danilo Medeiros Eler
 */
public class Biblioteca {
   private Config configuracoes;
   private Database db = Database.getInstance();

    public Biblioteca() {       
        this.configuracoes = new Config();
    }

    public Config getConfiguracoes() {
        return configuracoes;
    }

    public void setConfiguracoes(Config configuracoes) {
        this.configuracoes = configuracoes;
    }

    public void addAluno(String codUsuario, String nome, String curso, int ano){
        Aluno aluno = new Aluno(codUsuario, nome, curso, ano, configuracoes.getDiasAluno());
        db.addUsuario(aluno);
    }

    public void addProfessor(String codUsuario, String nome, String titulacao){
        Professor professor = new Professor(codUsuario, nome, titulacao, configuracoes.getDiasProfessor());
        db.addUsuario(professor);
    }

    public void addLivro(String codLivro, String nome, int ano) {
        Livro livro = new Livro(codLivro, nome, ano);
        db.addLivro(livro);
    }
    
    public Usuario buscarUsuario (String cod){
        
        Usuario usuarios[] = db.usuarios();
        for(int i = 0; i<usuarios.length; i++){
            if(usuarios[i].codUsuario.equals(cod)) 
                return usuarios[i];
        }
        return null;
    }
    
    public Livro buscarLivro (String cod){
        
        Livro livros[] = db.livros();
        for(int i = 0; i<livros.length; i++){
            if(livros[i].getCodLivro().equals(cod)) 
                return livros[i];
        }
        return null;
    }

    

}
