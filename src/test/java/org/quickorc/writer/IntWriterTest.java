package org.quickorc.writer;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.apache.hadoop.hive.ql.exec.vector.ColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.LongColumnVector;
import org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch;
import org.junit.Test;

public class IntWriterTest extends IntWriter {

	@Test
	public void testWrite() {
		LongColumnVector v = new LongColumnVector(2);
		VectorizedRowBatch batch = createMock(VectorizedRowBatch.class);
		replay(batch);
		batch.cols = new ColumnVector[2];
		batch.cols[0] = v;
		write(batch, 0, 1, 2);
		assertEquals(0L, v.vector[0]);
		assertEquals(2, v.vector[1]);
		verify(batch);	
	}
}
