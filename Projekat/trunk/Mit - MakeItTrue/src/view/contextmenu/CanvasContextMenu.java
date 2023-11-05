/***********************************************************************
 * Module:  CanvasContextMenu.java
 * Author:  G1
 ***********************************************************************/

package view.contextmenu;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import model.ApplicationModel;
/**Klasa koja definiše konteksni meni za kanvas.**/
public class CanvasContextMenu extends JPopupMenu {

	private static final long serialVersionUID = 1L;
	/**Element konteksog menija za isjecanje elemenata.**/
	private JMenuItem isjecanjeElemenata = null;
	/**Element konteksog menija za kopiranje elemenata.**/
	private JMenuItem kopiranjeElemenata = null;
	/**Element konteksog menija za lijepljenje elemenata.**/
	private JMenuItem lijepljenjeElemenata = null;
	/**Element konteksog menija za iscrtavanje mreže.**/
	private JCheckBoxMenuItem mrezaZaCrtanje = null;
	/**Element konteksog menija za rotiranje elemenata.**/
	private JMenuItem rotiranjeElementa = null;
	/**Element konteksog menija za horizontalno poravnanje elemenata.**/
	private JMenuItem horPoravnanjeElemenata = null;
	/**Element konteksog menija za vertikalno poravnanje elemenata.**/
	private JMenuItem verPoravnanjeElemenata = null;
	/**Element konteksog menija za spajanje elemenata.**/
	private JMenuItem spajanjeElemenata = null;
	/**Element konteksog menija za brisanje elemenata.**/
	private JMenuItem brisanjeElementa = null;
	/**Element konteksog menija za povratak na prethodni korak.**/
	private JMenuItem povratakNaPrethodniKorak = null;
	/**Element konteksog menija za poištavanja za povratak na prethodni korak.**/
	private JMenuItem povratakNaPonisteniKorak = null;

	public JMenuItem getIsjecanjeElemenata() {
		return isjecanjeElemenata;
	}

	public JMenuItem getKopiranjeElemenata() {
		return kopiranjeElemenata;
	}

	public JMenuItem getLijepljenjeElemenata() {
		return lijepljenjeElemenata;
	}

	public JCheckBoxMenuItem getMrezaZaCrtanje() {
		return mrezaZaCrtanje;
	}

	public JMenuItem getRotiranjeElementa() {
		return rotiranjeElementa;
	}

	public JMenuItem getHorPoravnanjeElemenata() {
		return horPoravnanjeElemenata;
	}

	public JMenuItem getVerPoravnanjeElemenata() {
		return verPoravnanjeElemenata;
	}

	public JMenuItem getSpajanjeElemenata() {
		return spajanjeElemenata;
	}

	public JMenuItem getBrisanjeElementa() {
		return brisanjeElementa;
	}

	public JMenuItem getPovratakNaPrethodniKorak() {
		return povratakNaPrethodniKorak;
	}

	public JMenuItem getPovratakNaPonisteniKorak() {
		return povratakNaPonisteniKorak;
	}

	public CanvasContextMenu(ApplicationModel model) {

		isjecanjeElemenata = new JMenuItem("Isjecanje");
		isjecanjeElemenata.setMnemonic(KeyEvent.VK_X);
		isjecanjeElemenata.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/cut.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(isjecanjeElemenata);

		kopiranjeElemenata = new JMenuItem("Kopiranje");
		kopiranjeElemenata.setMnemonic(KeyEvent.VK_C);
		kopiranjeElemenata.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/copy.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(kopiranjeElemenata);

		lijepljenjeElemenata = new JMenuItem("Lijepljenje");
		lijepljenjeElemenata.setMnemonic(KeyEvent.VK_V);
		lijepljenjeElemenata.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/paste.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(lijepljenjeElemenata);
		addSeparator();

		mrezaZaCrtanje = new JCheckBoxMenuItem("Mreža za crtanje");
		mrezaZaCrtanje.setState(true);
		mrezaZaCrtanje.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/grid.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(mrezaZaCrtanje);
		addSeparator();

		rotiranjeElementa = new JMenuItem("Rotiranje elementa");
		rotiranjeElementa.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/rotate.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(rotiranjeElementa);

		horPoravnanjeElemenata = new JMenuItem("Horizontalno poravnanje elemenata");
		horPoravnanjeElemenata.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/horizontal_aligh.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(horPoravnanjeElemenata);

		verPoravnanjeElemenata = new JMenuItem("Vertikalno poravnanje elemenata");
		verPoravnanjeElemenata.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/vertical_align.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(verPoravnanjeElemenata);

		spajanjeElemenata = new JMenuItem("Spajanje elemenata");
		spajanjeElemenata.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit()
				.getImage("icons/merge_elements.png").getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(spajanjeElemenata);

		brisanjeElementa = new JMenuItem("Brisanje elemenata");
		brisanjeElementa.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/delete_element.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		brisanjeElementa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		add(brisanjeElementa);
		addSeparator();

		povratakNaPrethodniKorak = new JMenuItem("Povratak na prethodni korak");
		povratakNaPrethodniKorak.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/undo.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(povratakNaPrethodniKorak);

		povratakNaPonisteniKorak = new JMenuItem("Povratak na poništeni korak");
		povratakNaPonisteniKorak.setIcon(new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getImage("icons/redo.png")
				.getScaledInstance(24, 24, Image.SCALE_AREA_AVERAGING)));
		add(povratakNaPonisteniKorak);
	}

}
