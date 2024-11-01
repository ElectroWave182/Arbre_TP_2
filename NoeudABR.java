public class NoeudABR<E extends Comparable<E>> extends Noeud<E>
{

	public Noeud<E> abr;
	
	public NoeudABR (E e)
	{
		super(e);
		abr = new Noeud<>(e);
	}
	
	public boolean recherche (E e)
	{
		E etiquette = abr.elt;
		if (etiquette.equals(e))
		{
			return true;
		}
		
		else if (etiquette.compareTo(e) < 1)
		{
			Noeud<E> droit = abr.filsD;
			if (droit == null)
			{
				return false;
			}
			return recherche(droit.elt);
		}
		Noeud<E> gauche = abr.filsG;
		if (gauche == null)
		{
			return false;
		}
		return recherche(gauche.elt);
	}
	
	public void inserer (E e)
	{
		E etiquette = abr.elt;

		if (etiquette.compareTo(e) < 1)
		{
			NoeudABR<E> droit = (NoeudABR<E>) abr.filsD;
			if (droit == null)
			{
				abr.filsD = new NoeudABR<>(e);
			}
			else
			{
				droit.inserer(e);
			}
		}
		
		else
		{
			NoeudABR<E> gauche = (NoeudABR<E>) abr.filsG;
			if (gauche == null)
			{
				abr.filsG = new NoeudABR<>(e);
			}
			else
			{
				gauche.inserer(e);
			}
		}
	}
	
	public static void main (String[] args)
	{
		
		NoeudABR<Character> arbre = new NoeudABR<>('f');
		arbre.inserer('z');
		arbre.inserer('d');
		arbre.inserer('i');
		arbre.inserer('r');
		arbre.inserer('p');
		arbre.inserer('i');
		
	}
	
}
