/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.hateoas;

import lombok.Getter;

/**
 * And {@link AffordanceModel} that derives the URI based on a {@link Link}.
 * 
 * @author Greg Turnquist
 */
public abstract class LinkBasedAffordanceModel implements AffordanceModel {

	private @Getter Link link;

	protected LinkBasedAffordanceModel(Link link) {
		this.link = link;
	}

	/**
	 * Get the name of an affordance's relation.
	 *
	 * @return
	 */
	@Override
	public String getRel() {
		return this.link.getRel();
	}

	/**
	 * Get the URI of an affordance.
	 *
	 * @return
	 */
	@Override
	public String getURI() {
		return this.link.expand().getHref();
	}
}
