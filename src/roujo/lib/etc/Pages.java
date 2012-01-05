package roujo.lib.etc;

public class Pages {
	public static void etendue(int pageDebut, int pageFin, int pagesParFeuille) {
		StringBuffer etendue = new StringBuffer("");
		String pages;
		final int nbDebut = pageDebut;
		final int nbFin   = pageFin;
		final int ppf     = pagesParFeuille;
		int lastPage = 0;
		int max = 0;
		System.out.println("Pages au recto:");
		for (int i = nbDebut; i <= nbFin; i = i + ppf * 2)
		{
			max = i + ppf - 1;
			if (max > nbFin)
			{
				lastPage = max - nbFin;
				max = nbFin;
			}
			pages = i + "-" + max;
			if (etendue.length() + pages.length() + 1 > 36)
			{
				System.out.println(etendue);
				etendue = new StringBuffer(pages);
			}
			else
			{
				if (etendue.length() > 0){
					etendue.append("," + pages);
				} else {
					etendue.append(pages);
				}
			}
		}
		System.out.println(etendue);
		System.out.println("");

		System.out.println("Pages au verso:");
		etendue = new StringBuffer("");
		
		if (max != nbFin)
		{
			if (lastPage != 0)
			{
				pages = nbFin + "";
			} else {
				pages = (nbFin - (3 - lastPage)) + "-" + nbFin;
			}
			System.out.println(pages);
		}
		
		for (int i = max - lastPage - ppf * 2 + 1; i >= nbDebut; i = i - ppf * 2)
		{
			pages = i + "-" + (i + ppf - 1);
			if (etendue.length() + pages.length() + 1 > 36)
			{
				System.out.println(etendue);
				etendue = new StringBuffer(pages);
			}
			else
			{
				if (etendue.length() > 0){
					etendue.append("," + pages);
				} else {
					etendue.append(pages);
				}
			}
		}
		System.out.println(etendue);
	}

}
