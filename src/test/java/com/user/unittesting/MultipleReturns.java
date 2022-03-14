package com.user.unittesting;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MultipleReturns {

	
	@Mock
	List<String> mock;
	
	@Test
	public void testSize()
	{
		when(mock.size()).thenReturn(5).thenReturn(7);
		assertEquals(5, mock.size());
		assertEquals(7, mock.size());
	}
	
	@Test
	public void testGet()
	{
		when(mock.get(0)).thenReturn("Venkat").thenReturn("Srinvas");
		assertEquals("Venkat", mock.get(0));
		assertEquals("Srinvas", mock.get(0));
	}
	
	
	@Test
	public void genericTestGet()
	{
		when(mock.get(ArgumentMatchers.anyInt())).thenReturn("Venkat")/* .thenReturn("Srinvas") */;
		assertEquals("Venkat", mock.get(0));
		assertEquals("Venkat", mock.get(1));
		assertEquals("Venkat", mock.get(7));
	}
	
	@Test
	public void verifymethodarguments()
	{
		String l=mock.get(1);
		verify(mock).get(1);
		verify(mock).get(ArgumentMatchers.anyInt());
		verify(mock,times(1)).get(ArgumentMatchers.anyInt());
	}
	
	
	@Test
	public void verifymethodArgumentcapturing()
	{
		mock.add("Venkat");
		
		
		ArgumentCaptor<String> captor= ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		assertEquals("Venkat", captor.getValue());
	}
	
	@Test
	public void verifymethodArgumentscapturing()
	{
		mock.add("Venkat");
		mock.add("Srinvas");
		mock.add("Tirumula");
		
		ArgumentCaptor<String> captor= ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		List<String> l=captor.getAllValues();
		
		assertEquals(3, l.size());
	}
	
	
	
}
