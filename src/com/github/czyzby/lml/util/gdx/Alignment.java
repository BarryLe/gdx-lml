package com.github.czyzby.lml.util.gdx;

import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

/** LibGDX alignments are simple integers and it's rather easy to make a mistake while using the align methods.
 * This enums wraps all default alignments, allowing to validate if the alignment value is actually correct.
 * No word separators for more natural use in LML tags.
 *
 * @author MJ */
public enum Alignment {
	CENTER(Align.center),
	TOP(Align.top),
	BOTTOM(Align.bottom),
	LEFT(Align.left),
	RIGHT(Align.right),
	TOPLEFT(Align.topLeft),
	TOPRIGHT(Align.topRight),
	BOTTOMLEFT(Align.bottomLeft),
	BOTTOMRIGHT(Align.bottomRight);

	private final int alignment;

	private Alignment(final int alignment) {
		this.alignment = alignment;
	}

	public int getAlignment() {
		return alignment;
	}

	public void apply(final Cell<?> cell) {
		cell.align(alignment);
	}

	/** @return true for TOP, TOP_LEFT and TOP_RIGHT. */
	public boolean isAlignedWithTop() {
		return (alignment & Align.top) != 0;
	}

	/** @return true for BOTTOM, BOTTOM_LEFT and BOTTOM_RIGHT. */
	public boolean isAlignedWithBottom() {
		return (alignment & Align.bottom) != 0;
	}

	/** @return true for LEFT, BOTTOM_LEFT and TOP_LEFT. */
	public boolean isAlignedWithLeft() {
		return (alignment & Align.left) != 0;
	}

	/** @return true for RIGHT, BOTTOM_RIGHT and TOP_RIGHT. */
	public boolean isAlignedWithRight() {
		return (alignment & Align.right) != 0;
	}

	/** @return true for CENTER. */
	public boolean isCentered() {
		return alignment == Align.center;
	}

	/** @return alignment converted to bitmap font utility HAlignment. */
	public HAlignment toHorizontalAlignment() {
		if (isAlignedWithLeft()) {
			return HAlignment.LEFT;
		} else if (isAlignedWithRight()) {
			return HAlignment.RIGHT;
		}
		return HAlignment.CENTER;
	}

	/** @param index ordinal of an enum constant.
	 * @return optional value of enum constant. Will be null for invalid index. */
	public static Alignment getByIndex(final int index) {
		return isIndexValid(index) ? values()[index] : null;
	}

	/** @param index a valid ordinal of an enum constant.
	 * @return enum constant with the selected index.
	 * @throws ArrayIndexOutOfBoundsException for invalid index. */
	public static Alignment getByValidIndex(final int index) {
		return values()[index];
	}

	/** @return true if the index is connected with an enum constant. */
	public static boolean isIndexValid(final int index) {
		return index >= 0 && index < values().length;
	}

	/** @return true if the index is connected with the last enum constant. */
	public static boolean isIndexLast(final int index) {
		return index == values().length - 1;
	}
}
