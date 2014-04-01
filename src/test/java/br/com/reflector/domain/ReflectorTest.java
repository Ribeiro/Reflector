package br.com.reflector.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.Matchers.*;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import br.com.reflector.exception.MissingPropertyException;

public class ReflectorTest {
	
	
	private User getUser(){
		return new User(1, "Geovanny Ribeiro", Arrays.asList(10000, 11000, 12000));
	}
	
	@Test
	public void shouldRetrieveUserNameCorrectly(){
		User user = getUser();
		assertThat(Reflector.reflectPrivatePropertyFrom(user, "name").toString(),equalTo("Geovanny Ribeiro"));
		
	}
	
	@Test
	public void shouldRetrieveUserIdCorrectly(){
		User user = getUser();
		assertThat(Reflector.reflectPrivatePropertyFrom(user, "id").toString(),equalTo("1"));
		
	}
	
	@Test
	public void shouldRetrieveUserEntitlementsCorrectly(){
		User user = getUser();
		@SuppressWarnings("unchecked")
		List<Integer> entitlements = (List<Integer>) Reflector.reflectPrivatePropertyFrom(user, "entitlements");
		assertThat(entitlements, hasSize(3));
		assertThat(entitlements, hasItems(10000, 11000, 12000));
		
	}
	
	@Test
	public void shouldReturnEmptyStringWhenPropertyIsNull(){
		User user = new User(2, null, Arrays.asList(10000, 11000, 12000));
		assertThat(Reflector.reflectPrivatePropertyFrom(user, "name").toString(),equalTo(""));
		
	}
	
	@Test(expected = MissingPropertyException.class)
	public void shouldThrowExceptionWhenSelectedPropertyIsMissingOnInstance(){
		User user = new User(2, "Janny Ribeiro", Arrays.asList(13000, 14000, 15000));
		Reflector.reflectPrivatePropertyFrom(user, "e");
		
	}

}