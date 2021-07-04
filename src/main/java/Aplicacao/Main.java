package Aplicacao;
import View.AplicacaoView;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) throws IOException {

    final WeldContainer container = new Weld().initialize();
    final AplicacaoView aplicacaoView = container.select(AplicacaoView.class).get();

    aplicacaoView.init();


    }


}
