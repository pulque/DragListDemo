# DragListDemo
**RecyclerView添加拖拽排序功能**

### 1. 实现功能
    通过继承ItemTouchHelper实现对元素的拖拽，可以排序和侧滑删除。
### 2. 实现步骤
    继承ItemTouchHelper.Callback，重写方法进行设置。
    设置长按拖拽和横向滑动删除。
    并对适配器回调方法，进行数据处理。
### 3. 关键代码
    //设置回调
    ItemTouchHelper.Callback callback = new TouchHelperCallback(adapter);
    //拖拽帮助类
    ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
    //作用在列表上
    touchHelper.attachToRecyclerView(binding.functionsList);
### 4. ItemTouchHelper.Callback说明
    isLongPressDragEnabled()是否可以长按拖拽
    isItemViewSwipeEnabled()是否可以侧滑删除
    getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder)
    滑动的方式设置
    当移动结束后回调onMove
    当侧滑删除后回调onSwiped
### 5. 总结
     其实ItemTouchHelper已经帮我们做了很多大量工作。
     
     如果不想长按来移动排序可以这样：
     1.监听item view中setOnTouchListener的onTouch方法
     2.通过接口将holder传给ItemTouchHelper
     3.调用touchHelper.startDrag(holder)开始拖拽
     
     代码：
     public interface StartDragListener {
         //触摸imageview，开启拖动的接口
         void startDragItem(RecyclerView.ViewHolder holder);
     }
     BaseAdapter：
     //set接口回调
     public void setDragListener(StartDragListener dragListener) {
         this.dragListener = dragListener;
     }
     
     holder.itemView.setOnTouchListener(new View.OnTouchListener() {
                 float x = 0;
                 float y = 0;
     
                 @Override
                 public boolean onTouch(View v, MotionEvent event) {
                     //注意：这里down和up都会回调该方法
                     if (event.getAction() == MotionEvent.ACTION_DOWN) {
                         x = event.getX();
                         y = event.getY();
                     } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                         float xTemp = event.getX();
                         float yTemp = event.getY();
                         if (xTemp - x > 5 || xTemp - x < -5 || yTemp - y > 5 || yTemp - y < -5) {
                             if (dragListener != null) {
                                 dragListener.startDragItem(holder);
                             }
                         }
                     }
                     return false;
                 }
             });
      
    @Override
    public void startDragItem(RecyclerView.ViewHolder holder) {
        touchHelper.startDrag(holder);
    }
    
