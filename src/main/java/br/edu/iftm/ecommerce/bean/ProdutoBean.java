package br.edu.iftm.ecommerce.bean;

import br.edu.iftm.ecommerce.logic.CategoriaLogic;
import br.edu.iftm.ecommerce.logic.MarcaLogic;
import br.edu.iftm.ecommerce.logic.ProdutoLogic;
import br.edu.iftm.ecommerce.model.Categoria;
import br.edu.iftm.ecommerce.model.Marca;
import br.edu.iftm.ecommerce.model.Produto;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ProdutoBean extends CrudBean<Produto, ProdutoLogic> {

    @Inject
    private ProdutoLogic logic;

    @Inject
    private MarcaLogic marcaLogic;

    private List<Marca> listaDeMarcas;
    @Inject
    private CategoriaLogic catLogic;

    private List<Categoria> listaDeCategorias;
    private Long ultimaAtualizacao = 0L;
    private Integer frequenciaAtualizacao = 5000;
    private Long ultimaAtualizacaoC = 0L;
    private Integer frequenciaAtualizacaoC = 5000;

    public ProdutoBean() {
        super(Produto.class);
    }

    @Override
    public ProdutoLogic getLogic() {
        return this.logic;
    }

    public List<Marca> getMarcas() {
        try {
            long proximaAtualizacao = this.ultimaAtualizacao + this.frequenciaAtualizacao;
            if (proximaAtualizacao < Calendar.getInstance().getTimeInMillis()) {
                this.listaDeMarcas = marcaLogic.buscar(null);
                this.ultimaAtualizacao = Calendar.getInstance().getTimeInMillis();
            }
            return this.listaDeMarcas;
        } catch (ErroSistemaException ex) {
            addErro(ex);
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        }
        return new ArrayList<>();
    }

    public List<Categoria> getCategorias() {
        try {
            long proximaAtualizacao = this.ultimaAtualizacaoC + this.frequenciaAtualizacaoC;
            if (proximaAtualizacao < Calendar.getInstance().getTimeInMillis()) {
                this.listaDeCategorias = catLogic.buscar(null);
                this.ultimaAtualizacaoC = Calendar.getInstance().getTimeInMillis();
            }
            return this.listaDeCategorias;
        } catch (ErroSistemaException ex) {
            addErro(ex);
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        }
        return new ArrayList<>();
    }

}
