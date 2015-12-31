package org.teachingextensions.logo.utils.InterfaceUtils;

import org.teachingextensions.logo.utils.LineAndShapeUtils.Paintable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CanvasPanel extends JPanel {
  private final ArrayList<Paintable> painters = new ArrayList<Paintable>();

  private static Graphics2D configureGraphics2D(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
    g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
    return g2d;
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);

    Graphics2D g2d = configureGraphics2D(g);
    for (Paintable p : this.getPainters()) {
      p.paint(g2d, this);
    }
  }

  public CanvasPanel remove(Paintable painter) {
    if (this.painters.contains(painter)) {
      this.painters.remove(painter);
    }
    return this;
  }

  public CanvasPanel add(Paintable painter) {
    if (!this.painters.contains(painter)) {
      this.painters.add(painter);
    }
    return this;
  }

  public CanvasPanel clear() {
    this.painters.clear();
    return this;
  }

  public ArrayList<Paintable> getPainters() {
    return new ArrayList<>(this.painters);
  }
}
