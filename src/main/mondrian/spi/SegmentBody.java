/*
// $Id$
// This software is subject to the terms of the Eclipse Public License v1.0
// Agreement, available at the following URL:
// http://www.eclipse.org/legal/epl-v10.html.
// Copyright (C) 2011-2011 Julian Hyde and others
// All Rights Reserved.
// You must accept the terms of that agreement to use this software.
*/
package mondrian.spi;

import java.io.Serializable;
import java.util.SortedSet;

import mondrian.rolap.agg.Segment;
import mondrian.rolap.agg.SegmentAxis;
import mondrian.rolap.agg.SegmentDataset;

/**
 * SegmentBody is the object which contains the cached data of a
 * Segment. They are stored inside a {@link mondrian.spi.SegmentCache}
 * and can be retrieved by a {@link SegmentHeader} key.
 *
 * <p>The segment body objects are immutable and fully serializable.
 *
 * @author LBoudreau
 * @version $Id$
 */
public interface SegmentBody extends Serializable {
    /**
     * Returns a SegmentDataset object which contains the cached
     * data and is initialized to be used with the supplied segment.
     *
     * @param segment Segment with which the returned dataset will be associated
     * @param axes Segment axes, containing actual column values
     * @return A SegmentDataset object that contains cached data.
     */
    SegmentDataset createSegmentDataset(Segment segment, SegmentAxis[] axes);

    /**
     * Returns the cached axis value sets to be used as an
     * initializer for the segment's axis.
     * @return An array of SortedSets which was cached previously.
     */
    SortedSet<Comparable<?>>[] getAxisValueSets();

    /**
     * Returns an array of boolean values which identify which
     * axis of the cached segment contained null values.
     * @return An array of boolean values.
     */
    boolean[] getNullAxisFlags();
}

// End SegmentBody.java