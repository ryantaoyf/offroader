package com.offroader.http;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class CountingInputStream extends FilterInputStream {

	private final ProgressListener listener;
	private long transferred;
	private long totalSize;

	protected CountingInputStream(final InputStream in, long totalSize, ProgressListener listener) {
		super(in);
		this.listener = listener;
		this.transferred = 0;
		this.totalSize = totalSize;
	}

	@Override
	public int read() throws IOException {
		int read = in.read();
		readCount(read);
		return read;
	}

	@Override
	public int read(byte[] buffer) throws IOException {
		int read = in.read(buffer);
		readCount(read);
		return read;
	}

	@Override
	public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
		int read = in.read(buffer, byteOffset, byteCount);
		readCount(read);
		return read;
	}

	@Override
	public long skip(long byteCount) throws IOException {
		long skip = in.skip(byteCount);
		readCount(skip);
		return skip;
	}

	private void readCount(long read) {
		if (read > 0) {
			this.transferred += read;
			this.listener.transferred(this.totalSize, this.transferred);
		}
	}

}
