package br.com.alura.leilao.model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LeilaoTest {

    public static final double DELTA = 0.0001;
    private final Leilao CONSOLE = new Leilao("Console");
    private final Usuario ALEX = new Usuario("Alex");

    @Test
    public void deve_DevolveDescricao_QuandoRecebeDescricao() {

        String descricaoDevolvida = CONSOLE.getDescricao();

        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeApenasUmLance(){
        CONSOLE.propoe(new Lance(ALEX,200.0));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvido, DELTA);

    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente(){
        CONSOLE.propoe(new Lance(new Usuario("Fran"),100.0));
        CONSOLE.propoe(new Lance(ALEX,200.0));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolveMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente(){
        CONSOLE.propoe(new Lance(ALEX,10000.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"),9000.0));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(10000.0,maiorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeApenasUmLance(){
        CONSOLE.propoe(new Lance(ALEX,200.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(200.0, menorLanceDevolvido, DELTA);

    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente(){
        CONSOLE.propoe(new Lance(new Usuario("Fran"),100.0));
        CONSOLE.propoe(new Lance(ALEX,200.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(100.0, menorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolveMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente(){
        CONSOLE.propoe(new Lance(ALEX,10000.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"),9000.0));

        double menorLanceDevolvido = CONSOLE.getMenorLance();

        assertEquals(9000.0,menorLanceDevolvido, DELTA);
    }

    @Test
    public void deve_DevolverTresMaioresLances_QuandoRecebeExatosTresLances(){
        CONSOLE.propoe(new Lance(ALEX,200.0));
        CONSOLE.propoe(new Lance(new Usuario("Fran"),300.0));
        CONSOLE.propoe(new Lance(ALEX,400.0));

        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();

        assertEquals(3,tresMaioresLancesDevolvidos.size());
        assertEquals(400.0,
                tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(300.0,
                tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);
        assertEquals(200.0,
                tresMaioresLancesDevolvidos.get(2).getValor(), DELTA);
    }

}