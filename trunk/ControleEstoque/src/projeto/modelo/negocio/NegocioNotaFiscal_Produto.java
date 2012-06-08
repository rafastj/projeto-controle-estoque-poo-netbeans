/**
 *
 */
package projeto.modelo.negocio;

import java.util.ArrayList;
import java.util.Collection;
import projeto.erro.ConexaoException;
import projeto.erro.GeralException;
import projeto.erro.RepositorioException;
import projeto.modelo.repositorio.*;
import projeto.modelo.to.NotaFiscal;
import projeto.modelo.to.NotaFiscal_Produto;
import projeto.modelo.to.Produto;

/**
 * @author diego
 *
 */
public class NegocioNotaFiscal_Produto {
    //variavel privada da Interface do Repositorio NotasFiscal_Produto

    private IRepositorioNotaFiscal_Produto repNotaFiscal_Produto;
    //variavel privada da Interface do Repositorio Produto
    private IRepositorioProduto repProduto;
    //variavel privada da Interface do Repositorio NotaFiscal
    private IRepositorioNotaFiscal repNotaFiscal;

    /**
     * Contrutor inicializa o atributo "repNotaFiscal_Produto" responsável pela
     * camada de acesso a dados
     */
    public NegocioNotaFiscal_Produto() {
        repNotaFiscal_Produto = new RepositorioNotaFiscal_Produto();
        repProduto = new RepositorioProduto();
        repNotaFiscal = new RepositorioNotaFiscal();
    }

    //SALVAR o vinculo de tal PRODUTO com uma certa NOTA FISCAL
    public void salvarNotaFiscal_Produto(int NotaFiscal_Codigo, int Produto_Codigo, int NotaFiscal_Quantidade) throws GeralException {


        if (NotaFiscal_Codigo <= 0) {
            throw new GeralException("Informe o número da Nota Fiscal");
        }

        if (Produto_Codigo <= 0) {
            throw new GeralException("Informe o número do Produto");
        }

        if (NotaFiscal_Quantidade <= 0) {
            throw new GeralException("Informe a Quantidade de Produtos");
        }

        try {

            //verificar se o codigo do PRODUTO informado existe na tabela produto
            Produto pconsul = repProduto.consultarCodigo(Produto_Codigo);
            if (pconsul == null) {
                throw new GeralException("O código do produto informado não existe!");
            }

            //Se não tem esse PRODUTO disponivel
            if (pconsul.getProdutos_Quantidade() == 0) {
                throw new GeralException("Produto esgotado!");
            }

            //verificar se a quantidade desejada informa existe em estoque na tabela PRODUTOS
            if (pconsul.getProdutos_Quantidade() < NotaFiscal_Quantidade) {
                throw new GeralException("A quantidade é superior! deste produto temos essa quantidade.: " + pconsul.getProdutos_Quantidade());
            }

            //verificar se o código da NOTAFISCAL informada existe na tabela NotaFiscal
            NotaFiscal nconsul = repNotaFiscal.consultar(NotaFiscal_Codigo);
            if (nconsul == null) {
                throw new GeralException("O código da Nota Fiscal informado não existe!");
            }

            //verificar se a NOTAFISCAL ainda esta em aberta
            if (nconsul.getNotasFiscal_Status() == true) {
                throw new GeralException("A Nota Fiscal Pode ser");
            }


            //VERIFICAÇÃO se exite estes vinculo dentro da tabela NotaFiscal_Produto
            NotaFiscal_Produto npconsul = repNotaFiscal_Produto.consultarNotaFiscal_Produto(NotaFiscal_Codigo, Produto_Codigo);
            if (npconsul != null) {
                throw new GeralException("Esse Produto já possui vinculo com essa Nota Fiscal!");
            }


            //Variavel que irar receber o valor total da quantidade do produto
            double valorQuantidade = (pconsul.getProdutos_ValorVenda() * NotaFiscal_Quantidade);



            /////////ALTERAR A QUANTIDADE DO PRODUTO RETIRADO NO MOVIMENTO DA NOTAFISCAL
            try {
                //Atualizar a Quantidade na tabela PRODUTOS
                Produto pAtualizar = new Produto(); //criada pAtualizar do Produto
                pAtualizar.setProdutos_Codigo(pconsul.getProdutos_Codigo());//Codigo do Produto
                //Isso irar subtrair a quantidade atual pela solicitada para compra
                pAtualizar.setProdutos_Quantidade(pconsul.getProdutos_Quantidade() - NotaFiscal_Quantidade);

                //Chama o DAO responsável pela alteração da quantidade
                repNotaFiscal_Produto.atualizarProdutoQtde(pAtualizar);

            } catch (RepositorioException ex) {
                throw new GeralException("Diego fez caca! No Alterar da Quantidade do Produto!");
            } catch (ConexaoException ex) {
                throw new GeralException("O banco de dados não está acessível!");
            }

            /////////SOMANDO A VALOR DA NOTA FISCAL COM O VALOR TOTAL DA QUANTIDADE DE PRODUTOS SOLICITADOS NA INCLUSÃO DESSE PRODUTO NA NOTA
            try {
                //Atualizar a Tabela NOTASFICAIS passando os parametros de cada atributo
                NotaFiscal nAtualizar = new NotaFiscal();
                nAtualizar.setNotasFiscal_Numero(nconsul.getNotasFiscal_Numero());

                //Unico local onde irar ser realmente alterado é o valor da nota fiscal
                nAtualizar.setNotasFiscal_ValorNotaFiscal(nconsul.getNotasFiscal_ValorNotaFiscal() + valorQuantidade);

                //Chama o DAO responsável pela alteração do valor total
                repNotaFiscal_Produto.atualizarNotaFiscalValordaNota(nAtualizar);

            } catch (RepositorioException ex) {
                throw new GeralException("Diego fez caca! No Alterar da Quantidade do NotaFiscal!");
            } catch (ConexaoException ex) {
                throw new GeralException("O banco de dados não está acessível!");
            }

            //criar o objeto já setando os seus valores da NotaFiscal_Produto
            NotaFiscal_Produto np = new NotaFiscal_Produto();
            np.setNotasFiscal_Numero(NotaFiscal_Codigo);
            np.setProdutos_Codigo(Produto_Codigo);
            np.setNotasFiscalProdutos_Quantidade(NotaFiscal_Quantidade);
            np.setNotasFiscalProdutos_ValorQuantidade(valorQuantidade);


            //Chama o DAO responsável pala inclusão desse produto na tabela de relacionamento de Nota Fiscal e Produtos
            repNotaFiscal_Produto.salvar(np);

        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }

    }

    //CONSULTAR todos os PRODUTOS vinculados ao
    public NotaFiscal_Produto consultarNotaFiscal_Produto(int NotaFiscal_Numero) throws GeralException {

        NotaFiscal_Produto np = null;

        if (NotaFiscal_Numero <= 0) {
            throw new GeralException("Informe o Número da Nota Fiscal!");
        }

        try {

            //verificar se o Número da NOTAFISCAL informada existe na tabela NotaFiscal
            NotaFiscal nconsul = repNotaFiscal.consultar(NotaFiscal_Numero);
            if (nconsul == null) {
                throw new GeralException("O número da Nota Fiscal informado não existe!");
            }

            //chama o DAO responsável pela Consulta dos produtos pertencentes ao número da nota informado
            np = repNotaFiscal_Produto.consultarNotaFiscal_Numero(NotaFiscal_Numero);

            //verificar se existe produto vinculado a nota fiscal
            if (np == null) {
                throw new GeralException("A Nota Fiscal não possuir Produtos!");
            }

        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return np;
    }

    //CONSULTAR um determinado vinculo de tal NOTA FISCAL com um certo PRODUTO
    public NotaFiscal_Produto consultarNotaFiscal_Produto(int NotaFiscal_Numero, int Produtos_Codigo) throws GeralException {
        NotaFiscal_Produto np = null;

        if (NotaFiscal_Numero <= 0) {
            throw new GeralException("Informe o Número da Nota Fiscal!");
        }

        if (Produtos_Codigo <= 0) {
            throw new GeralException("Informe o Número da Nota Fiscal!");
        }

        try {

            //verificar se o Número da NOTAFISCAL informada existe na tabela NotaFiscal
            NotaFiscal nconsul = repNotaFiscal.consultar(NotaFiscal_Numero);
            if (nconsul == null) {
                throw new GeralException("O número da Nota Fiscal informado não existe!");
            }

            //verificar se o Código do PRODUTO informada existe na tabela NotaFiscal
            Produto pconsul = repProduto.consultarCodigo(Produtos_Codigo);
            if (pconsul == null) {
                throw new GeralException("O Código do Produto informado não existe!");
            }


            //chama o DAO responsável pela Consulta dos produtos pertencentes ao número da nota informado
            np = repNotaFiscal_Produto.consultarNotaFiscal_Produto(NotaFiscal_Numero, Produtos_Codigo);

            //verificar se existe produto vinculado a nota fiscal
            if (np == null) {
                throw new GeralException("Essa Nota Fiscal não possuir vinculo com esse Produto!");
            }

        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return np;
    }

    //EXCLUIR o vinculo da nota fiscal com o tala produto!
    public void excluirNotaFiscal_Produto(int NotaFiscal_Numero, int Produtos_Codigo) throws GeralException {

        if (NotaFiscal_Numero <= 0) {
            throw new GeralException("Informe o número da Nota Fiscal");
        }

        if (Produtos_Codigo <= 0) {
            throw new GeralException("Informe o código do Produto");
        }

        try {
            //verificar se exite esse produto na nota fiscal informada
            NotaFiscal_Produto npconsul = repNotaFiscal_Produto.consultarNotaFiscal_Produto(NotaFiscal_Numero, Produtos_Codigo);
            if (npconsul == null) {
                throw new GeralException("Não existe produto nesta Nota Fiscal!");
            }

            //chama o DAO responsável pela EXCLUSÃO dessa vinculo
            repNotaFiscal_Produto.excluir(NotaFiscal_Numero, Produtos_Codigo);

        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }

    //LISTAR todos o PRODUTOS vinculado a NOTA FISCAL
    public Collection<NotaFiscal_Produto> lista(int notaFiscal_Numero) throws GeralException {

        ArrayList<NotaFiscal_Produto> lista;

        //verificar se foi relamente informado número da Nota Fiscal
        if (notaFiscal_Numero <= 0) {
            throw new GeralException("Informe o Número da Nota Fiscal!");
        }

        try {

            //verificar se o Número da NOTAFISCAL informada existe na tabela NotaFiscal
            NotaFiscal nconsul = repNotaFiscal.consultar(notaFiscal_Numero);
            if (nconsul == null) {
                throw new GeralException("O número da Nota Fiscal informado não existe!");
            }

            //verificar se o Número da NOTA FISCAL possuir vinculo com algum produto!
            NotaFiscal_Produto npconsul = repNotaFiscal_Produto.consultarNotaFiscal_Numero(notaFiscal_Numero);
            if (npconsul == null) {
                throw new GeralException("Nota Fiscal de número.: " + notaFiscal_Numero + " não possui nenhum produto vinculado!");
            }

            //chama a camada dao com a possivel lista!
            lista = (ArrayList<NotaFiscal_Produto>) new RepositorioNotaFiscal_Produto().lista(notaFiscal_Numero);

            //se caso não tiver dados
            if (lista == null) {
                throw new GeralException("Não tem dados na");
            }
        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return lista;
    }
    
    

    //ALTERAR o vinculo da NOTA FISCAL com o tal PRODUTO
    public void atualizarNotaFiscal_Produto(NotaFiscal_Produto npOld, NotaFiscal_Produto npNew) throws GeralException {

        if (npOld.getNotasFiscal_Numero() <= 0 || npNew.getNotasFiscal_Numero() <= 0) {
            throw new GeralException("Informe o número da Nota Fiscal");
        }

        if (npOld.getProdutos_Codigo() <= 0 || npNew.getProdutos_Codigo() <= 0) {
            throw new GeralException("Informe o número do Produto");
        }

        if (npNew.getNotasFiscalProdutos_Quantidade() <= 0) {
            throw new GeralException("Informe a quantidade!");
        }

        try {
            /**
             * CONSULTAR DO PRODUTO OLD
             */
            //CONSULTAR a quantidade vinculada com essa NOTA FISCAL
            NotaFiscal_Produto npconsulOld = repNotaFiscal_Produto.consultarNotaFiscal_Produto(npOld.getNotasFiscal_Numero(), npOld.getProdutos_Codigo());


            //CONSULTAR os dados do PRODUTO
            Produto pconsulOld = repProduto.consultarCodigo(npOld.getProdutos_Codigo());
            if (pconsulOld == null) {
                throw new GeralException("O código do produto informado não existe!");
            }

            //CONSULTAR os dados dessa NOTA FISCAL
            NotaFiscal nconsulOld = repNotaFiscal.consultar(npOld.getNotasFiscal_Numero());
            if (nconsulOld == null) {
                throw new GeralException("Nota Fiscal não existe!");
            }
            /**
             * TRATAMENTO NO PRODUTO OLD
             */
            try {
                //DEVOLVE A QUANTIDADE AO PRODUTO
                Produto pAtualizar = new Produto();
                pAtualizar.setProdutos_Codigo(npOld.getProdutos_Codigo());
                pAtualizar.setProdutos_Quantidade(pconsulOld.getProdutos_Quantidade() + npconsulOld.getNotasFiscalProdutos_Quantidade());//QUANTIDADE ATUAL DE PRODUTO
                repNotaFiscal_Produto.atualizarProdutoQtde(pAtualizar);//Chama o DAO responsável pela alteração da quantidade
            } catch (RepositorioException ex) {
                throw new GeralException("Diego fez caca!");
            } catch (ConexaoException ex) {
                throw new GeralException("O banco de dados não está acessível!");
            }
            //RETIRAR O VALOR TOTAL do antigo PRODUTO DA NOTA FISCAL
            try {
                NotaFiscal nAtualizar = new NotaFiscal();
                nAtualizar.setNotasFiscal_Numero(npOld.getNotasFiscal_Numero());
                nAtualizar.setNotasFiscal_ValorNotaFiscal(nconsulOld.getNotasFiscal_ValorNotaFiscal() - npconsulOld.getNotasFiscalProdutos_ValorQuantidade());//retira o antigo valor desse produto nessa nota fiscal
                repNotaFiscal_Produto.atualizarNotaFiscalValordaNota(nAtualizar);//Chama o DAO responsável pela alteração do valor total

            } catch (RepositorioException ex) {
                throw new GeralException("Diego fez caca! No Alterar da Quantidade do NotaFiscal!");
            } catch (ConexaoException ex) {
                throw new GeralException("O banco de dados não está acessível!");
            }
        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca! No Alterar da Quantidade do NotaFiscal!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }

        try {
            /**
             * CONSULTAR DO PRODUTO New
             */
            //CONSULTAR os dados do PRODUTO
            Produto pconsulNew = repProduto.consultarCodigo(npNew.getProdutos_Codigo());
            if (pconsulNew == null) {
                throw new GeralException("O código do produto informado não existe!");
            }

            //CONSULTAR os dados dessa NOTA FISCAL
            NotaFiscal nconsulNew = repNotaFiscal.consultar(npNew.getNotasFiscal_Numero());
            if (nconsulNew == null) {
                throw new GeralException("Nota Fiscal não existe!");
            }

            //Se não tem esse PRODUTO disponivel
            if (pconsulNew.getProdutos_Quantidade() == 0) {
                throw new GeralException("Produto esgotado!");
            }

            //verificar se a quantidade desejada informa existe em estoque na tabela PRODUTOS
            if (pconsulNew.getProdutos_Quantidade() < npNew.getNotasFiscalProdutos_Quantidade()) {
                throw new GeralException("A quantidade é superior! deste produto temos essa quantidade.: " + pconsulNew.getProdutos_Quantidade());
            }

            //Variavel que irar receber o valor total da quantidade do produto
            double valorQuantidade = (pconsulNew.getProdutos_ValorVenda() * npNew.getNotasFiscalProdutos_Quantidade());

            /**
             * TRATAMENTO NO PRODUTO NEW
             */
            try {
                //RETIRAR NOVA QUANTIDADE DO PRODUTO
                Produto pAtualizar = new Produto();
                pAtualizar.setProdutos_Codigo(npNew.getProdutos_Codigo());
                pAtualizar.setProdutos_Quantidade(pconsulNew.getProdutos_Quantidade() - npNew.getNotasFiscalProdutos_Quantidade());//Quantidade - a Solicitada
                repNotaFiscal_Produto.atualizarProdutoQtde(pAtualizar);//Chama o DAO responsável pela alteração da quantidade
            } catch (RepositorioException ex) {
                throw new GeralException("Diego fez caca!");
            } catch (ConexaoException ex) {
                throw new GeralException("O banco de dados não está acessível!");
            }
            //Inserir O VALOR TOTAL do novo PRODUTO DA NOTA FISCAL
            try {


                NotaFiscal nAtualizar = new NotaFiscal();
                nAtualizar.setNotasFiscal_Numero(npOld.getNotasFiscal_Numero());
                nAtualizar.setNotasFiscal_ValorNotaFiscal(nconsulNew.getNotasFiscal_ValorNotaFiscal() + valorQuantidade);//retira o antigo valor desse produto nessa nota fiscal
                repNotaFiscal_Produto.atualizarNotaFiscalValordaNota(nAtualizar);//Chama o DAO responsável pela alteração do valor total

            } catch (RepositorioException ex) {
                throw new GeralException("Diego fez caca! No Alterar da Quantidade do NotaFiscal!");
            } catch (ConexaoException ex) {
                throw new GeralException("O banco de dados não está acessível!");
            }
            try {

                //criar o objeto já setando os seus valores da NotaFiscal_Produto
                NotaFiscal_Produto np = new NotaFiscal_Produto();
                np.setNotasFiscal_Numero(npNew.getNotasFiscal_Numero());
                np.setProdutos_Codigo(npNew.getProdutos_Codigo());
                np.setNotasFiscalProdutos_Quantidade(npNew.getNotasFiscalProdutos_Quantidade());
                np.setNotasFiscalProdutos_ValorQuantidade(valorQuantidade);
                np.getProduto().setProdutos_Codigo(npOld.getProdutos_Codigo());
                repNotaFiscal_Produto.atualizarNotaFiscal_Produto(np);//Chama o DAO responsável pala inclusão desse produto na tabela de relacionamento de Nota Fiscal e Produtos

            } catch (RepositorioException ex) {
                throw new GeralException("Diego fez caca!");
            } catch (ConexaoException ex) {
                throw new GeralException("O banco de dados não está acessível!");
            }
        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca! No Alterar da Quantidade do NotaFiscal!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
    }
    
    //LISTAR todos o PRODUTOS vinculado a NOTA FISCAL
    public Collection<NotaFiscal_Produto> listaProdutos(int notaFiscal_Numero) throws GeralException {

        ArrayList<NotaFiscal_Produto> lista;

        try {
            //chama a camada dao com a possivel lista!
            lista = (ArrayList<NotaFiscal_Produto>) new RepositorioNotaFiscal_Produto().lista(notaFiscal_Numero);

        } catch (RepositorioException ex) {
            throw new GeralException("Diego fez caca!");
        } catch (ConexaoException ex) {
            throw new GeralException("O banco de dados não está acessível!");
        }
        return lista;
    }    
    
    
    
//FIM
}