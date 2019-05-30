package br.com.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.TreeNode;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.junit.experimental.categories.Categories;
import org.primefaces.model.DefaultTreeNode;

import br.com.models.PlataformaModel;
import entities.Genero;
import entities.Plataforma;

@SuppressWarnings("serial")
@ManagedBean(name = "plataformaBean")
@RequestScoped
public class PlataformaBean implements Serializable {
	private List<Plataforma> plataformas;
	private MenuModel menuModel;
	List<DefaultSubMenu> defaultSubMenus;
	private List<DefaultMenuItem> defaultMenuItems;
	List<String> generos;

	public MenuModel getMenuModel() {
		return menuModel;
	}

	private PlataformaModel getPlataformaModel() {
		PlataformaModel plataformaModel = new PlataformaModel();
		return plataformaModel;
	}

	public List<Plataforma> getPlataformas() {
		return plataformas;
	}

	@PostConstruct
	public void list() {
		this.menuModel = new DefaultMenuModel();
		this.defaultSubMenus = new ArrayList<>();
		this.plataformas = new ArrayList<>();
		this.generos = new ArrayList<>();
		this.defaultMenuItems = new ArrayList<>();
		try {
			this.plataformas = getPlataformaModel().list();
			this.defaultSubMenus.add(0, new DefaultSubMenu("INICIO", "/paginas/index.xhtml"));
			for (Plataforma p : this.plataformas) {
				this.defaultSubMenus.add(new DefaultSubMenu(p.getTipoPlataforma()));
			}

			for (int i = 1; i < this.defaultSubMenus.size(); i++) {
				switch (i) {
				case 1:
					this.generos = getPlataformaModel().buscarPorGenero(i);
					for (String g : this.generos) {
						this.defaultMenuItems.add(new DefaultMenuItem(g));
					}
					for (DefaultMenuItem menuItem : this.defaultMenuItems) {
						this.defaultSubMenus.get(i).addElement(menuItem);
					}
					break;

				case 2:
					this.generos = getPlataformaModel().buscarPorGenero(2);
					if (!this.generos.isEmpty()) {
						for (String g : this.generos) {
							this.defaultMenuItems.add(new DefaultMenuItem(g));
						}
						for (DefaultMenuItem menuItem2 : defaultMenuItems) {
							this.defaultSubMenus.get(i).addElement(menuItem2);
						}
						break;
					}

				case 3:
					if (!this.generos.isEmpty()) {
						this.generos = getPlataformaModel().buscarPorGenero(3);
						for (String g : this.generos) {
							this.defaultMenuItems.add(new DefaultMenuItem(g));
						}
						for (DefaultMenuItem menuItem3 : defaultMenuItems) {
							this.defaultSubMenus.get(i).addElement(menuItem3);
						}
					}
					break;

				case 4:
					this.generos = getPlataformaModel().buscarPorGenero(4);
					if (!this.generos.isEmpty()) {
					for (String g : this.generos) {
						this.defaultMenuItems.add(new DefaultMenuItem(g));
					}
					for (DefaultMenuItem menuItem4 : defaultMenuItems) {
						this.defaultSubMenus.get(i).addElement(menuItem4);
					}
					}
					break;
				default:
					break;
				}
			}

			for (DefaultSubMenu submenus : this.defaultSubMenus) {
				submenus.setStyle("padding:10px;");
				this.menuModel.addElement(submenus);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
