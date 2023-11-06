package EjerciciosObjetos.O11Pokimon;

public class PokiMochila {

	Pokimon pok1,pok2,pok3;
	
	//-----Constructores-----
	
	public PokiMochila() {}
	
	public PokiMochila (Pokimon pok1) {
		
		this.pok1 = pok1;
		this.pok2 = new Pokimon();
		this.pok3 = new Pokimon();
	}
	
	//-----Setters y getters-----
	
	public Pokimon getPok1() {
		return pok1;
	}
	public void setPok1 (Pokimon pok1) {
		this.pok1 = pok1;
	}

	public Pokimon getPok2() {
		return pok2;
	}
	public void setPok2 (Pokimon pok2) {
		this.pok2 = pok2;
	}

	public Pokimon getPok3() {
		return pok3;
	}
	public void setPok3 (Pokimon pok3) {
		this.pok3 = pok3;
	}
	
	//-----Métodos-----
	
	public void capturar (Pokimon pokCapturado) {

		if (pok1.isCapturado()) {
			if (pok2.isCapturado()) {
				if (pok3.isCapturado()) {
	            	System.out.println ("No se ha podido capturar");
				}else{
				    pok3 = pokCapturado;
	            	System.out.println ("Se ha capturado en el espacio 3");
		            pokCapturado.setCapturado(true);
                }
			}else{
			    pok2 = pokCapturado;
	            System.out.println ("Se ha capturado en el espacio 2");
		        pokCapturado.setCapturado(true);
            }
		}else {
			pok1 = pokCapturado;
	        System.out.println ("Se ha capturado en el espacio 1");
		    pokCapturado.setCapturado(true);
		}
	}
	public void liberarPokimon (int opcionPokimon) {
	        switch (opcionPokimon) {
	            case 1: {
	            	if (pok1.isCapturado()) {
	            		pok1.setCapturado (false);
	            		System.out.println ("Liberado.");
	            	}
	            	else {
	            		System.out.println ("No hay nada aquí.");
	            	}
	            	break;
	            }
	            case 2: {
	            	if (pok2.isCapturado()) {
	            		pok2.setCapturado (false);
	            		System.out.println ("Liberado.");
	            	}
	            	else {
	            		System.out.println ("No hay nada aquí.");
	            	}
	            	break;
	            }
	            case 3: {
	            	if (pok3.isCapturado()) {
	            		
	            		pok3.setCapturado (false);
	            		System.out.println ("Liberado.");
	            	}
	            	else {
	            		System.out.println ("No hay nada aquí.");
	            	}
	            	break;
	            }
	        }
	}
}
