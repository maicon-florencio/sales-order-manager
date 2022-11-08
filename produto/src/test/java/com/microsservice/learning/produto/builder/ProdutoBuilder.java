package com.microsservice.learning.produto.builder;

import com.microsservice.learning.produto.dominio.Produto;
import com.microsservice.learning.produto.dominio.enun.ProdutoStatusEnum;
import com.microsservice.learning.produto.service.dto.ProdutoDTO;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Component
public class ProdutoBuilder {

    public Produto criarProduto(Long id){
        return Produto.builder()
                .id(id)
                .name("Potato Chips")
                .description("Pizza peperone")
                .price(17.15f)
                .dtVencimento(Calendar.getInstance())
                .statusP(ProdutoStatusEnum.APROVADO.getNomeTipo())
                .build();
    }
    public Produto criarProdutoNovo(){
        return Produto.builder()
                .name("Potato Chips")
                .price(17.15F)
                .description("Pizza peperone")
                .dtVencimento(Calendar.getInstance())
                .statusP(ProdutoStatusEnum.APROVADO.getNomeTipo())
                .build();
    }
    public ProdutoDTO criarProdutoDTONovo(){
        return ProdutoDTO.builder()
                .name("Baby beef")
                .price(69.90F)
                .desc("sanduiche de atum")
                .dtVencimento(Calendar.getInstance())
                .statusProduto(ProdutoStatusEnum.APROVADO.getNomeTipo())
                .build();
    }

    public ProdutoDTO criarProdutoDTO(Long id){
        return ProdutoDTO.builder()
                .id(id)
                .name("Baby beef")
                .price(69.90F)
                .desc("sanduiche de atum")
                .dtVencimento(Calendar.getInstance())
                .statusProduto(ProdutoStatusEnum.APROVADO.getNomeTipo())
                .build();
    }

    public List<ProdutoDTO> listaProdutoDTONew(){
        var pDTO1
                = ProdutoDTO.builder().id(1L).name("Kibi Charque").desc("Comida Arabe")
                .price(15.65F).statusProduto(ProdutoStatusEnum.APROVADO.getNomeTipo()).dtVencimento(Calendar.getInstance())
                .build();
        var pDTO2
                = ProdutoDTO.builder().id(1L).name("Pastel Frango").desc("pastel de 15cm recheado com frango e queijo")
                .price(12.65F).statusProduto(ProdutoStatusEnum.APROVADO.getNomeTipo()).dtVencimento(Calendar.getInstance())
                .build();
        var pDTO3
                = ProdutoDTO.builder().id(1L).name("Banoffer").desc("Doce de creme com pedacos de banana")
                .price(18.00F).statusProduto(ProdutoStatusEnum.APROVADO.getNomeTipo()).dtVencimento(Calendar.getInstance())
                .build();

        return Arrays.asList(pDTO1,pDTO2,pDTO3);
    }

    public List<Produto> listaProdutoNew(){
        var pDTO1
                = Produto.builder().id(1L).name("Kibi Charque").description("Comida Arabe")
                .price(15.65F).statusP(ProdutoStatusEnum.APROVADO.getNomeTipo()).dtVencimento(Calendar.getInstance())
                .build();
        var pDTO2
                = Produto.builder().id(1L).name("Pastel Frango").description("pastel de 15cm recheado com frango e queijo")
                .price(12.65F).statusP(ProdutoStatusEnum.APROVADO.getNomeTipo()).dtVencimento(Calendar.getInstance())
                .build();
        var pDTO3
                = Produto.builder().id(1L).name("Banoffer").description("Doce de creme com pedacos de banana")
                .price(18.00F).statusP(ProdutoStatusEnum.APROVADO.getNomeTipo()).dtVencimento(Calendar.getInstance())
                .build();

        return Arrays.asList(pDTO1,pDTO2,pDTO3);
    }

}
