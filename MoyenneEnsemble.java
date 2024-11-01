import java.util.Random;
import java.util.TreeSet;

public class MoyenneEnsemble
{

	public static void main (String[] args)
	{
		
		Random gnr = new Random();
		
		TreeSet<Integer> t = new TreeSet<>();
		@SuppressWarnings("unchecked")
		TreeSet<Integer> ens = (TreeSet<Integer>) t.clone();
		
		for (int i = 0; i < 15; i ++)
		{
			t.add(gnr.nextInt(101));
		}
		
		int taille = ens.size();
		
		int m = 0;
		for (int i = 0; i < 15; i ++)
		{
			m += t.pollFirst();
		}
		m /= taille;
		
		int v;
		int bas = t.floor(m);
		int haut = t.ceiling(m);
		int ecartDown = Math.abs(bas - m);
		int ecartUp = Math.abs(haut - m);
		
		if (ecartUp > ecartDown)
		{
			v = bas;
		}
		else
		{
			v = haut;
		}
		
		System.out.println("Ensemble : " + ens);
		System.out.println("Moyenne : " + m);
		System.out.println("Valeur proche : " + v);
		
	}

}
