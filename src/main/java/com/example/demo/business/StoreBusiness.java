package com.example.demo.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Store;
import com.example.ontology.SparqlService;

@Service
public class StoreBusiness {
	//Store nbaStore = new Store("c3f6f6ae1a4411ea978f2e728ce88125", "Esportes" , "Loja NBA" , "A loja Loja NBA foi inaugurada em Outubro de 2017, em parceria com a Netshoes, responsável pela administração e logística da vitrine virtual. O objetivo da parceria é oferecer a maior variedade de artigos esportivos e de lazer para quem é apaixonado pelo esporte.", "http://www.theplayoffs.com.br/wp-content/uploads/2018/03/nba-store-brasil-e1519915445743.jpg", "1ºAndar , Loja 10"); 
	//Store surfTrip = new Store("2be2fcf81a4611ea978f2e728ce88125", "Esportes" , "Surf Trip" , "Nossa loja e galeria lhe dará a chance de lembrar um momento, um sentimento ou qualquer coisa que você tenha experimentado na sua vida, permitiremos que você leve o que gostou desse espaço para a sua casa.", "http://larmar.com.br/wp-content/uploads/2017/07/ambiente-espaco_lar-mar_foto-leo-feltran_0093.jpg", "1ºAndar , Loja 21");
	//Store deal = new Store("af9bca5c1a4611ea978f2e728ce88125", "Roupas" , "Deal" , "Após décadas de bom desempenho, a empresa passou por uma profunda reestruturação no início dos anos 1990 e começou a operar no formato de loja de departamentos especializada em moda.", "http://www.madanretails.com/wp-content/uploads/2019/05/IMG_6628-870x580.jpg", "1ºAndar , Loja 13");
	//Store blackBull = new Store("4811d97a1a4711ea978f2e728ce88125", "Roupas" , "BlackBull" , "Desde o início, temos focado na oferta de roupas prontas para usar e de qualidade para todas as pessoas. Atualmente, estamos ampliando essa visão para oferecer roupas bonitas e sustentáveis a um nível de preço conveniente para todos.", "https://www.galeriadaarquitetura.com.br/Img/projeto/SF1/3034/blackbull4107.jpg", "2ºAndar , Loja 3");
	//Store lojaDoMusico = new Store("4e71e0d01a4711ea978f2e728ce88125", "Instrumentos" , "Loja do músico" , "Temos Grande disponibilidade de Acessórios como: Captadores, Pontes, Encordoamentos, Tarraxas, Capotrastes, Palhetas, Bocais, Afinadores, Clamps, Correias e etc.", "http://www.islmusic.com.br/wp-content/gallery/nova-importadora-sao-luiz/Fotos-Calend%C3%A1rio-Editadas-4-copiar.jpg", "2ºAndar , Loja 7");
	ArrayList<Store> listStores = new ArrayList<Store>();
	
	public Store createNewStore(Store store) {
		store.setId( UUID.randomUUID().toString());
		listStores.add(store);
		return store;
	}
	public List<Store> listStores(){
		listStores.addAll(SparqlService.selectStore());
		return listStores;
	}
}
