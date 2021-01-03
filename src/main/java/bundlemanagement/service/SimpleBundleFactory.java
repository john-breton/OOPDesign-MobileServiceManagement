package bundlemanagement.service;

import bundlemanagement.preconf.Bundle;

public interface SimpleBundleFactory {
	public abstract Bundle createBundle(String name);
}
