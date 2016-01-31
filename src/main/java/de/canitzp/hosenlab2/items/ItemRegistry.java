package de.canitzp.hosenlab2.items;

public class ItemRegistry {

    public static ItemDust dustBauxite;
    public static ItemPassport hosePassport, ellpeckPassport, xdjackiexdPassport, nullxDDPassport;
    public static CrateSpawner crateMK1, crateMK2, crateMK3;

    public static void preInit(){
        dustBauxite = new ItemDust("dustBauxite");
        hosePassport = new ItemPassport("xdqmhose", "1990", "Male", "Hosencorp", "Never", "9BN98-YWKR4", ItemPassport.Nationality.ARSTOTZKA, ItemPassport.Granted.GRANTED, "2015");
        ellpeckPassport = new ItemPassport("Ellpeck", "21.05.1999", "Male", "Peck Inc.", "Cant remember", "5HF09-502D6", ItemPassport.Nationality.ARSTOTZKA, ItemPassport.Granted.GRANTED, "666");
        xdjackiexdPassport = new ItemPassport("XDjackieXD", "27.09.1997", "Male", "Chaos Inc.", "NOPE", "SMJ52-8QEVC", ItemPassport.Nationality.CAOSFIELD, ItemPassport.Granted.GRANTED, "29.07.2007");
        nullxDDPassport = new ItemPassport("0xDD", "Long before Christ", "Male", "God", "Never", "S595U-UIQ3U", ItemPassport.Nationality.ARSTOTZKA, ItemPassport.Granted.GRANTED, "2015 31.02");
        crateMK1 = new CrateSpawner("MK1");
        crateMK2 = new CrateSpawner("MK2");
        crateMK3 = new CrateSpawner("MK3");
    }

}
