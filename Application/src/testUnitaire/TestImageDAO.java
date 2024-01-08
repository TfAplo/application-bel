package testUnitaire;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.ImageDAO;
import metier.Image;

class TestImageDAO {

	private ImageDAO imageDao;
	@Test
	void test() {
		
		ImageDAO imageDao = new ImageDAO();
		Image ref = imageDao.lire(1);
		Image test = new Image("113.tif","C:UsersvalenDownloadsArchive113.tif",2048.0,2048.0,10.0,10.0,1,1);
		test.setIdImage(1);
		System.out.println(ref);
		System.out.println(test);
		
		assert isEqual(ref, test);
		
		
	}
	
	
    /*
     * Compare si deux image sont eguale (avec leurs id qui est unique)
     */
    public static boolean isEqual(Image image1, Image image2) {
        if (image1.getIdImage() == image2.getIdImage()) {
        	System.out.println("ok");
            if (image1.getNomImage() == image2.getNomImage()) {
            	System.out.println("ok");
            	if (image1.getUrl() == image2.getUrl()) {
            		System.out.println("ok");
            		if (image1.getLargeurPx() == image2.getLargeurPx()) {
            			System.out.println("ok");
            			if (image1.getHauteurPx() == image2.getLargeurPx()) {
            				System.out.println("ok");
            				if (image1.getGrossissement() == image2.getGrossissement()) {
            					System.out.println("ok");
            					if (image1.getLargeurReelle() == image2.getLargeurReelle()) {
            						System.out.println("ok");
            						if (image1.getIdOperateur() == image2.getIdOperateur()) {
            							System.out.println("ok");
            							if (image1.getIdProduit() == image2.getIdProduit()) {
            								System.out.println("ok");
            	                        	return true;
            	                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

}
